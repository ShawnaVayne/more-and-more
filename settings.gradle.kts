import java.util.Properties

pluginManagement {

    repositories {
        mavenCentral()
//        maven {
//            this.isAllowInsecureProtocol = true
//            this.url = java.net.URI.create("${extra["INDRA_PLUGIN_REPOSITORY_URL"]}")
//            credentials {
//                username = "${extra["INDRA_PLUGIN_REPOSITORY_USERNAME"]}"
//                password = "${extra["INDRA_PLUGIN_REPOSITORY_PASSWORD"]}"
//            }
//        }
    }

}

rootProject.name = "${extra["ROOT_PROJECT_NAME"]}"

// 引入自定义插件
//includeBuild("gradle/trainer-plugin")
includeBuild("gradle/custom-plugin")


val includedDemo = "${extra.properties.getOrDefault("includedDemo", "true")}".toBoolean()

class ModuleManifest(
    val path: String, val name: String, private val enabled: Boolean, private val demo: Boolean
) {

    fun canInclude(): Boolean {
        return enabled && (includedDemo || !demo)
    }

    override fun toString(): String {
        return "name='$name', path='$path', enabled=$enabled, demo=$demo"
    }

}


fun File.forEachSubFiles(filter: File.() -> Boolean, action: File.() -> Unit) {
    if (isDirectory.not()) {
        return
    }
    listFiles()?.forEach {
        if (it.filter()) {
            if (it.isDirectory) {
                it.forEachSubFiles(filter, action)
            } else {
                it.action()
            }
        }
    }
}

fun ProjectDescriptor.forEachModuleManifests(action: ModuleManifest.() -> Unit) {
    val excludedNames = setOf("build", "logs")
    projectDir.forEachSubFiles({
        if (isDirectory) {
            name.startsWith(".").not().and(name !in excludedNames)
        } else {
            name == "module-manifest.properties"
        }
    }, {
        val properties = Properties()
        properties.load(this.reader(Charsets.UTF_8))
        val path = parentFile.relativeToOrSelf(projectDir).path
        val enabled = properties.getProperty("ENABLED", "false").toBoolean()
        val demo = properties.getProperty("DEMO", "false").toBoolean()
        ModuleManifest(path, parentFile.name, enabled, demo).action()
    })
}

println("++++++++++ 环境 ++++++++++")

extra.properties.entries.forEach {
    println("  ${it.key}=${it.value}")
}

println("---------- 环境 ----------")

println("> 开始配置[${extra["ROOT_PROJECT_NAME"]}]项目")

println(">> 是否包含demo模块: $includedDemo")

var moduleCount = 0
var includedCount = 0

rootProject.forEachModuleManifests {
    println(">> 发现模块: $this")
    moduleCount++
    if (this.canInclude()) {
        include(":${name}")
        if (path != name) {
            project(":${name}").projectDir = file(path)
        }
        includedCount++
    }
}

println("> 共发现模块[${moduleCount}]个，需要导入[${includedCount}]个 \n\n")


//enableFeaturePreview("VERSION_CATALOGS")
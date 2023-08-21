import java.net.URI

plugins {
    id("java-gradle-plugin")
    kotlin("jvm") version "1.6.21"
    application
}

repositories {
    maven {
        this.isAllowInsecureProtocol = true
        this.url = URI.create("${extra["INDRA_PUBLIC_REPOSITORY_URL"]}")
        credentials {
            username = "${extra["INDRA_PUBLIC_REPOSITORY_USERNAME"]}"
            password = "${extra["INDRA_PUBLIC_REPOSITORY_PASSWORD"]}"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    //添加Gradle相关的API，否则无法自定义Plugin和Task
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    implementation("org.thymeleaf:thymeleaf:3.1.0.RC1")
    implementation("com.xiaoleilu:hutool-all:3.3.2")
}

gradlePlugin {
    plugins {
        create("CustomPlugin") {
            id = "com.indrasoft.plugin.custom"
            implementationClass = "com.indrasoft.custom.plugin.CustomPlugin"
        }

    }
}
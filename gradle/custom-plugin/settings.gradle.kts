import java.util.Properties

pluginManagement {

    repositories {
        maven {
            this.isAllowInsecureProtocol = true
            this.url = java.net.URI.create("${extra["INDRA_PLUGIN_REPOSITORY_URL"]}")
            credentials {
                username = "${extra["INDRA_PLUGIN_REPOSITORY_USERNAME"]}"
                password = "${extra["INDRA_PLUGIN_REPOSITORY_PASSWORD"]}"
            }
        }
    }

}

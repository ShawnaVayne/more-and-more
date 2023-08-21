package cn.godlovesus.custom.plugin

import org.gradle.api.artifacts.dsl.DependencyHandler

class ModuleDependencyHandler constructor(private val dependencyHandler: DependencyHandler) {

    internal fun api(path: String) {
        dependencyHandler.api(dependencyHandler.project(path))
    }

}
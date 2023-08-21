package cn.godlovesus.custom.plugin

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.api(dependencyNotation: Any): Dependency? = add("api", dependencyNotation)

/**
 * 管理模块依赖
 */
fun DependencyHandler.moduleDependencies(action: ModuleDependencyHandler.() -> Unit) {
    val moduleDependencyHandler = ModuleDependencyHandler(this)
    action.invoke(moduleDependencyHandler);
}

fun Project.moduleDependencies(action: ModuleDependencyHandler.() -> Unit) {
    val moduleDependencyHandler = ModuleDependencyHandler(this.dependencies)
    action.invoke(moduleDependencyHandler);
}


fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency =
    uncheckedCast(
        project(
            if (configuration != null) mapOf("path" to path, "configuration" to configuration)
            else mapOf("path" to path)
        )
    )


@Suppress("UNCHECKED_CAST")
internal fun <T> uncheckedCast(obj: Any?): T =
    obj as T
package de.fayard.refreshVersions.core.internal

import org.gradle.api.Task
import kotlin.reflect.full.memberFunctions

@InternalRefreshVersionsApi
fun Task.skipConfigurationCache() {
    val gradle74Method =  this::class.memberFunctions.firstOrNull { it.name == "notCompatibleWithConfigurationCache" }
    if (gradle74Method == null) {
        println("Warning: task $name not compatible with the configuration cache.")
    } else {
        gradle74Method.call(this, "Task $name does not support Configuration Cache")
    }
}
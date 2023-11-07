package org.bmsk.effectivekotlin

import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureTest() {
    configureJunit()
    val libs = extensions.libs
    dependencies {
        "testImplementation"(libs.findLibrary("kotest.runner.junit5").get())
        "testImplementation"(libs.findLibrary("assertj.core").get())
        "testImplementation"(libs.findLibrary("junit.jupiter").get())
    }
}

internal fun Project.configureJunit() {
    tasks.apply {
        withType<KotlinCompile>().configureEach {
            kotlinOptions.jvmTarget = "11"
        }
        withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
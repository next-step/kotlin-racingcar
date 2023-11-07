plugins {
    id("effectivekotlin.kotlin.library")
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "org.bmsk.effectivekotlin.model"
version = "1.0-SNAPSHOT"

tasks {
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}

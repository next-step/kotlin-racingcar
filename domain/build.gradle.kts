plugins {
    id("effectivekotlin.kotlin.library")
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "org.bmsk.effectivekotlin"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(projects.model)
}

tasks {
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}

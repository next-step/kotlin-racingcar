plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(projects.domain)
    implementation(projects.model)

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj.core)
    testImplementation(libs.kotest.runner.junit5)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}

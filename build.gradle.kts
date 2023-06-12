plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion = "5.6.2"
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.8.2")
    testImplementation("org.assertj", "assertj-core", "3.22.0")
    testImplementation("io.kotest", "kotest-runner-junit5", kotestVersion)
    testImplementation("io.kotest", "kotest-framework-datatest", kotestVersion)
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

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
    jacoco
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.8.2")
    testImplementation("org.assertj", "assertj-core", "3.22.0")
    testImplementation("io.kotest", "kotest-runner-junit5", "5.2.3")
    testImplementation("io.kotest", "kotest-framework-datatest", "5.2.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
        finalizedBy("jacocoTestReport")
    }
    ktlint {
        verbose.set(true)
    }
    jacocoTestReport {
        reports {
            html.required.set(true)
            xml.required.set(true)
        }
        finalizedBy("jacocoTestCoverageVerification")
    }
    jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = "0.30".toBigDecimal()
                }
            }

            rule {
                enabled = true
                element = "CLASS"

                limit {
                    counter = "BRANCH"
                    value = "COVEREDRATIO"
                    minimum = "0.90".toBigDecimal()
                }

                limit {
                    counter = "LINE"
                    value = "COVEREDRATIO"
                    minimum = "0.80".toBigDecimal()
                }

                limit {
                    counter = "LINE"
                    value = "TOTALCOUNT"
                    maximum = "400".toBigDecimal()
                }

                excludes = listOf(
                    "main.*"
                )
            }
        }
    }
}

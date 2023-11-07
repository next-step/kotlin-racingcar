import org.bmsk.effectivekotlin.configureKotlin
import org.bmsk.effectivekotlin.configureTest
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
}

configureKotlin()
configureTest()

tasks {
    test {
        useJUnitPlatform()
    }
}

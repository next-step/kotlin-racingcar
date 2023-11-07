plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.verify.detektPlugin)
}

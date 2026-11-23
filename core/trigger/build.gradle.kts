plugins {
    alias(libs.plugins.ylog.kmp.serialization)
    alias(libs.plugins.ylog.kmp.compose)
    alias(libs.plugins.ylog.kmp.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.designsystem)
        }
    }
}

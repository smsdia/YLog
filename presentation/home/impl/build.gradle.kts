plugins {
    alias(libs.plugins.ylog.kmp.feature)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentation.home.api)
        }
    }
}

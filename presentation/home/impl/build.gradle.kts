plugins {
    alias(libs.plugins.ylog.kmp.feature)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.common)

            implementation(projects.presentation.home.api)

            implementation(libs.coil.compose)
        }
    }
}

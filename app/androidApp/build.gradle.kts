plugins {
    alias(libs.plugins.ylog.android.application)
}

android {
    namespace = "com.sonms.ylog"

    defaultConfig {
        applicationId = "com.sonms.ylog"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.app.shared)
}

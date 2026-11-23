plugins {
    alias(libs.plugins.ylog.kmp.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // DataStore<Preferences>가 공개 API에 노출되므로 api로 전이한다
            api(libs.androidx.datastore.preferences.core)
        }
    }
}

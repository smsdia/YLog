plugins {
    `kotlin-dsl`
}

dependencies {
    // compileOnly: plugin 클래스는 사용하는 프로젝트의 classpath에서 실제 구현을 가져온다
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.compose.compilerGradlePlugin)
    compileOnly(libs.ktlint.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpLibrary") {
            id = "ylog.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("kmpCompose") {
            id = "ylog.kmp.compose"
            implementationClass = "KmpComposeConventionPlugin"
        }
        register("kmpSerialization") {
            id = "ylog.kmp.serialization"
            implementationClass = "KmpSerializationConventionPlugin"
        }
        register("androidApplication") {
            id = "ylog.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("kmpFeature") {
            id = "ylog.kmp.feature"
            implementationClass = "KmpFeatureConventionPlugin"
        }
    }
}

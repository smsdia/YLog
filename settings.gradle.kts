rootProject.name = "YLog"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":app:androidApp")
include(":app:shared")

include(
    ":core:ar",
    ":core:common",
    ":core:database",
    ":core:datastore",
    ":core:designsystem",
    ":core:imageprocessing",
    ":core:model",
    ":core:navigation",
    ":core:trigger",
)
include(
    ":presentation:home:api",
    ":presentation:home:impl",
)

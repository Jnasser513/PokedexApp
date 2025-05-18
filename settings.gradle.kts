pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokedexApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":pokemon:data")
include(":pokemon:domain")
include(":pokemon:presentation")
include(":pokemon:network")
include(":core:data")
include(":core:domain")
include(":core:presentation:designsystem")
include(":core:presentation:ui")
include(":core:database")

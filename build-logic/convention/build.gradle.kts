plugins {
    `kotlin-dsl`
}
group = "com.jnasser.pokemon.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "pokedex.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "pokedex.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "pokedex.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "pokedex.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeatureUi") {
            id = "pokedex.android.feature.ui"
            implementationClass = "AndroidFeatureUIConventionPlugin"
        }
        register("androidRoom") {
            id = "pokedex.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("jvmLibrary") {
            id = "pokedex.jvm.library"
            implementationClass = "JVMLibraryConventionPlugin"
        }
        register("jvmKtor") {
            id = "pokedex.jvm.ktor"
            implementationClass = "JVMKtorConventionPlugin"
        }
    }
}
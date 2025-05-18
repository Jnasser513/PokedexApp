plugins {
    alias(libs.plugins.pokedex.android.library)
}

android {
    namespace = "com.jnasser.pokemon.network"
}

dependencies {
    implementation(libs.bundles.koin)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.data)
}
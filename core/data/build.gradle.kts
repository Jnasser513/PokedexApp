plugins {
    alias(libs.plugins.pokedex.android.library)
}

android {
    namespace = "com.jnasser.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)
    implementation(libs.androidx.datastore.preference)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.database)
}
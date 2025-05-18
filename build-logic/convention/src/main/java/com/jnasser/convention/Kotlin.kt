package com.jnasser.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configures common Kotlin and Android settings for all modules that use this convention.
 */
internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        // Set compile SDK version from version catalog
        compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()

        // Set minimum SDK version from version catalog
        defaultConfig.minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()

        // Enable Java 11 and core library desugaring
        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }

    // Configure Kotlin compiler options
    configureKotlin()

    dependencies {
        // Add dependency for core library desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugar.jdk.libs").get())
    }
}

/**
 * Applies Kotlin-specific compiler configuration to all Kotlin compile tasks.
 */
private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
}

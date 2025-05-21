import com.jnasser.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Gradle convention plugin for Kotlin JVM projects using Ktor.
 * Applies Kotlin serialization plugin and adds Ktor dependencies.
 */
class JVMKtorConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            // Apply Kotlin serialization plugin
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            // Add Ktor dependency bundle
            dependencies {
                "implementation"(libs.findBundle("ktor").get())
            }
        }
    }
}

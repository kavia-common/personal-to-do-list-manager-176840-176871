pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Mirror the plugin used in settings.gradle.dcl for DCL support
    id("org.gradle.experimental.android-ecosystem") version "0.1.43"
}

rootProject.name = "example-android-app"

// Ensure analyzers and Gradle see the same modules as declared in settings.gradle.dcl
include("app")
include("list")
include("utilities")

# Android Project Root (Gradle Declarative DSL)

This directory is the root of the Android project for analysis and builds.

Key files:
- settings.gradle.dcl (Gradle Declarative DSL)
- app/build.gradle.dcl
- list/build.gradle.dcl
- utilities/build.gradle.dcl
- gradle/wrapper/gradle-wrapper.properties
- gradlew, gradlew.bat

Primary application module:
- app (namespace: org.example.app)

To build/install (from this directory):
./gradlew :app:installDebug

Notes:
- The project uses Gradle 9 Declarative (.dcl) files instead of traditional Groovy/Kotlin DSL.
- Some analyzers expect settings.gradle(.kts). Use this folder as the project root.

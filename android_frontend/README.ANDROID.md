# Android/Kotlin Project (Gradle)

This is the Android project root.

Key indicators:
- gradlew / gradlew.bat with gradle/wrapper/gradle-wrapper.properties
- settings.gradle.dcl (primary) and a compatibility settings.gradle for analyzers
- build.gradle (compatibility stub for analyzers)
- Modules: :app, :list, :utilities

Build (if needed):
./gradlew :app:assembleDebug

Project root for Gradle is this folder.

Run commands from here:
- ./gradlew tasks
- ./gradlew :app:assembleDebug
- ./gradlew :app:installDebug

Modules are declared in settings.gradle.dcl:
- include("app")
- include("list")
- include("utilities")

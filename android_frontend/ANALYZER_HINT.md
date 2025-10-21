Android project root: this directory (android_frontend)

Structure summary:
- settings.gradle.dcl (Gradle 9 Declarative)
- gradle/ and gradlew scripts
- modules: app/, list/, utilities/
- primary Android app module: app/ (contains src/main/AndroidManifest.xml and Kotlin sources)
- additional standalone design assets: assets/ (web preview only; not part of Gradle build)

Notes for tools:
- Use settings.gradle.dcl to discover included modules.
- The app module contains the main entrypoint activity: org.example.app.MainActivity.
- Assets/splashscreen-1-2.* are static HTML/CSS/JS for design parity and should not be compiled by Gradle.

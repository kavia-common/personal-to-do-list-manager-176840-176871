Android/Kotlin project root is located at: android_frontend

How to build (from android_frontend):
- ./gradlew :app:assembleDebug
- ./gradlew :app:installDebug

Key files/folders:
- android_frontend/settings.gradle.dcl (includes modules: app, list, utilities)
- android_frontend/gradlew, gradlew.bat, gradle/wrapper/
- android_frontend/app/src/main/AndroidManifest.xml
- android_frontend/assets/ (standalone web preview assets; not part of Gradle build)

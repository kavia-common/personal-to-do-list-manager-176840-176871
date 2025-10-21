CI Note: Android Gradle project root is the "android_frontend" directory in this workspace.

Run Gradle from this path:
  cd android_frontend && ./gradlew :app:assembleDebug

If your analyzer starts at the repository root, use the proxy:
  ./gradlew :app:tasks
which delegates to android_frontend/gradlew.

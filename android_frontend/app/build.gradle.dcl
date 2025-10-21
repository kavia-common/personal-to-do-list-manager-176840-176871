androidApplication {
    namespace = "org.example.app"

    dependencies {
        // Core
        implementation("androidx.core:core-ktx:1.13.1")

        // AppCompat + Fragment + RecyclerView (XML-based UI)
        implementation("androidx.appcompat:appcompat:1.7.0")
        implementation("androidx.fragment:fragment-ktx:1.8.3")
        implementation("androidx.recyclerview:recyclerview:1.3.2")

        // Lifecycle ViewModel
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")

        // Room for local persistence
        implementation("androidx.room:room-runtime:2.6.1")
        implementation("androidx.room:room-ktx:2.6.1")

        // Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

        // Remove compose dependencies now that UI is XML-based
        // implementation("androidx.activity:activity-compose:1.9.2")
        // implementation("androidx.compose.ui:ui:1.7.2")
        // implementation("androidx.compose.material3:material3:1.3.0")
        // implementation("androidx.compose.ui:ui-tooling-preview:1.7.2")
        // implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")
        // implementation("androidx.compose.ui:ui-tooling:1.7.2")

        // Keep existing module dep if needed by default template (not used in new app)
        // implementation(project(":utilities"))
    }
}

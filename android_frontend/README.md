# Ocean Professional To‑Do (Android)

A Compose-based Android to‑do list app with local Room persistence and an Ocean Professional Material 3 theme.

Features:
- Add tasks via text field and IME action
- Edit, delete, and toggle completion
- Filter by All, Active, Completed
- Persists tasks locally with Room
- Material 3 theme using Ocean Professional palette

Build and Run:
- From this directory:
  ./gradlew :app:installDebug

Open the app on the device/emulator: "Ocean Pro To‑Do"

Notes:
- Uses Gradle Declarative DSL; only the dependencies block was modified in app/build.gradle.dcl.
- Icons are represented by simple glyphs (✎, 🗑) to avoid adding extra icon dependencies under DCL constraints.
- No external services required. Supabase can be integrated later.

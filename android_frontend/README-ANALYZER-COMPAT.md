This Android project primarily uses Gradle Declarative DSL (.dcl):
- settings.gradle.dcl
- app/list/utilities build.gradle.dcl

To assist CI/analyzers that cannot parse .dcl, conventional Gradle shims have been added:
- Root: settings.gradle(.kts), build.gradle(.kts)
- Modules: app/list/utilities build.gradle (Groovy DSL)

These shims mirror the DCL module structure and basic settings but do not replace the DCL source of truth.

How to build locally:
- cd android_frontend && ./gradlew :app:assembleDebug

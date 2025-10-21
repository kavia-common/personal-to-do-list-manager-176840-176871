#!/usr/bin/env bash
# Helper to run Gradle commands from the correct Android project root.
# Usage: bash run-android-gradle.sh <gradle-args>
set -euo pipefail
cd "$(dirname "$0")/android_frontend"
exec ./gradlew "$@"

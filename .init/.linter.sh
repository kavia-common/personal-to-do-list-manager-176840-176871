#!/bin/bash
cd /home/kavia/workspace/code-generation/personal-to-do-list-manager-176840-176871/android_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi


#!/bin/bash
#run fs in background and wait  https://freeswitch.org/confluence/display/FREESWITCH/Command+Line+Switches
freeswitch -ncwait
#run tests
./gradlew clean test
# results at build/reports/tests/index.html
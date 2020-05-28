#!/bin/bash
#mvn -Dmaven.test.skip=true clean install
java -jar ./build/domain-0.0.1-SNAPSHOT-exec.jar
java -jar ./build/account-0.0.1-SNAPSHOT.jar &
java -jar ./build/common-0.0.1-SNAPSHOT.jar &
java -jar ./build/contact-0.0.1-SNAPSHOT.jar &
java -jar ./build/email-0.0.1-SNAPSHOT.jar &
java -jar ./build/event-0.0.1-SNAPSHOT.jar &
java -jar ./build/invoice-0.0.1-SNAPSHOT.jar &
java -jar ./build/lead-0.0.1-SNAPSHOT.jar &
java -jar ./build/opportunity-0.0.1-SNAPSHOT.jar &
java -jar ./build/planner-0.0.1-SNAPSHOT.jar &
java -jar ./build/task-0.0.1-SNAPSHOT.jar &
java -jar ./build/team-0.0.1-SNAPSHOT.jar &
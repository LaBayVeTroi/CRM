#!/bin/bash
mvn -Dmaven.test.skip=true clean install
java -jar ./domain/target/domain-0.0.1-SNAPSHOT-exec.jar
java -jar ./account/target/account-0.0.1-SNAPSHOT.jar &
java -jar ./common/target/common-0.0.1-SNAPSHOT.jar &
java -jar ./contact/target/contact-0.0.1-SNAPSHOT.jar &
java -jar ./email/target/email-0.0.1-SNAPSHOT.jar &
java -jar ./event/target/event-0.0.1-SNAPSHOT.jar &
java -jar ./invoice/target/invoice-0.0.1-SNAPSHOT.jar &
java -jar ./lead/target/lead-0.0.1-SNAPSHOT.jar &
java -jar ./opportunity/target/opportunity-0.0.1-SNAPSHOT.jar &
java -jar ./planner/target/planner-0.0.1-SNAPSHOT.jar &
java -jar ./task/target/task-0.0.1-SNAPSHOT.jar &
java -jar ./team/target/team-0.0.1-SNAPSHOT.jar &
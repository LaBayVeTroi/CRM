#!/bin/bash
java -jar ./build/domain-0.0.1-SNAPSHOT-exec.jar &
java -jar ./build/account-management-0.0.1-SNAPSHOT.jar &
java -jar ./build/task-management-0.0.1-SNAPSHOT.jar &
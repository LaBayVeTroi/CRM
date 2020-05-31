java -jar ./domain-0.0.1-SNAPSHOT-exec.jar &
java -jar ./account-management-0.0.1-SNAPSHOT.jar &
java -jar ./task-management-0.0.1-SNAPSHOT.jar &
wait
tail run.sh

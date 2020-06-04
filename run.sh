java -jar -Xmx512m  ./domain-0.0.1-SNAPSHOT-exec.jar &
java -jar -Xmx512m ./account-management-0.0.1-SNAPSHOT.jar &
java -jar -Xmx512m ./task-management-0.0.1-SNAPSHOT.jar &
wait
tail run.sh

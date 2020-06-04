#!/bin/bash
mvn -Dmaven.test.skip=true clean install
rm ./build/*.*
find ./ -type f | grep -i jar$ | xargs -i cp {} ./build

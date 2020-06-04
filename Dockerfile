FROM openjdk:8-jdk-buster
WORKDIR /opt/var/
COPY ./build .
COPY ./run.sh .
RUN chmod +x ./run.sh
ENTRYPOINT ["bash","/opt/var/run.sh"]
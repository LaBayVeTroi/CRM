FROM maven:3.6.3-jdk-8-openj9
WORKDIR /opt/var/
COPY . .
RUN chmod +x ./run.sh
ENTRYPOINT ["/opt/var/run.sh"]
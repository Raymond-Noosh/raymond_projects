FROM openjdk:8-jdk-alpine
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /opt/myservice/services.jar
VOLUME /tmp

# Add the service
#ARG JAR_FILE
COPY /target/config-0.0.1-SNAPSHOT.jar /opt/myservice/services.jar
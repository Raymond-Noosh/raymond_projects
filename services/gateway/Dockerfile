FROM openjdk:8-jdk-alpine
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom ${JAVA_OPTS} -jar /opt/myservice/services.jar
VOLUME /tmp

# Add the service
ARG JAR_FILE
COPY /target/${JAR_FILE} /opt/myservice/services.jar
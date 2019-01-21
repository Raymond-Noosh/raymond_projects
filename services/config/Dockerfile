FROM maven:3.5.4-jdk-8-alpine AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jdk-alpine
COPY --from=build /tmp/target/config-0.0.1-SNAPSHOT.jar /opt/myservice/services.jar
ENTRYPOINT ["java","-jar","/opt/myservice/services.jar"]
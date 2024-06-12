FROM openjdk:17-jdk-alpine

MAINTAINER kucingngoding.com

COPY target/user-0.0.1-SNAPSHOT.jar user-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/user-0.0.1-SNAPSHOT.jar"]
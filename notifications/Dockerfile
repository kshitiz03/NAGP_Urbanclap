FROM openjdk:8-jdk-alpine
MAINTAINER kshitiz.rawat@nagarro.com
WORKDIR /opt
COPY ./target/notifications-0.0.1-SNAPSHOT.jar /opt/
ENTRYPOINT ["java","-jar","notifications-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082
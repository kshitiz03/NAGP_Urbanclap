FROM openjdk:8-jdk-alpine
MAINTAINER kshitiz.rawat@nagarro.com
WORKDIR /opt
COPY ./target/Service-discovery-0.0.1-SNAPSHOT.jar /opt/
ENTRYPOINT ["java","-jar","Service-discovery-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761
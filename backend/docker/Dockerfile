FROM openjdk:8-jdk-alpine

COPY ./target/MStore-0.0.1-SNAPSHOT.jar ./mstore.jar
COPY ./images ./images

EXPOSE 8443

CMD ["java", "-jar", "mstore.jar"]
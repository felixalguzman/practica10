FROM openjdk:8-jdk-alpine


EXPOSE 8080

COPY practica10-0.0.1-SNAPSHOT.jar practica10.jar

ENTRYPOINT ["java", "-jar", "practica10.jar"]

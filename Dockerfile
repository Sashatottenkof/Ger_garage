FROM openjdk:8

COPY build/libs/Ger_garage-0.0.1-SNAPSHOT.jar /app/Ger_garage-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/Ger_garage-0.0.1-SNAPSHOT.jar"]
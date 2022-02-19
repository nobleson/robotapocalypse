FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/apocalypse.jar
COPY ${JAR_FILE} .
EXPOSE 8080
CMD [ "java", "-jar",  "/apocalypse.jar"]
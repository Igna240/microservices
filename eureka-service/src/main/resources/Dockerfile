FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=eureka-ms-0.0.1-SNAPSHOT.jar
COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8761
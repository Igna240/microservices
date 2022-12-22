FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=gateway-ms-0.0.1-SNAPSHOT.jar
COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
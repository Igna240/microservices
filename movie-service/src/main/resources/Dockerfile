FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=movie-service-1.0.0-SNAPSHOT.jar
COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
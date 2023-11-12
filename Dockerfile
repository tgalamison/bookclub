FROM eclipse-temurin:11-jdk
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","bookclub.jar"]
EXPOSE 8080
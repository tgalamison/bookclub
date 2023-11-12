FROM maven:3.6.3-eclispe-temurin-11-alpine AS build
VOLUME /tmp
COPY . .
RUN mvn clean package -DskipTests
ENTRYPOINT ["java","-jar","bookclub.jar"]
EXPOSE 8080
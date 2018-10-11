FROM openjdk:8-jdk
COPY ./springbackend/build/libs/mt-backend-0.0.1-SNAPSHOT.jar* /usr/share/springbackend/mt-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/usr/share/springbackend/mt-backend-0.0.1-SNAPSHOT.jar"]

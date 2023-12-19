FROM openjdk:17-jdk-alpine
COPY ./target/employee-*.jar employee-0.0.1-SNAPSHOT.jar
EXPOSE 8099
CMD java -jar employee-0.0.1-SNAPSHOT.jar
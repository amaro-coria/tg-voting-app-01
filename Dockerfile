FROM openjdk:8-jre-alpine
COPY ./target/voting-0.0.1-SNAPSHOT.jar /usr/share/app.jar
EXPOSE 8080
CMD [ "java" , "-jar" , "/usr/share/app.jar" ]
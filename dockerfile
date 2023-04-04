FROM openjdk:17
COPY ./app /usr/src/myapp
WORKDIR /usr/src/myapp
# RUN javac gpt-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar kyu-chat-server-0.0.1-SNAPSHOT.jar
CMD ["java", "Main"]
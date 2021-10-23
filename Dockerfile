FROM openjdk:8-alpine
COPY ./target/* $HOME/web-app/
WORKDIR $HOME/web-app/
ENTRYPOINT ["java","-jar","*.jar"]
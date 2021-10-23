FROM openjdk:8-alpine
RUN mkdir $HOME/web-app
WORKDIR $HOME/web-app/
COPY ./target/backend-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java","-jar","backend-0.0.1-SNAPSHOT.jar"]

#before executing docker build make sure to have latest sprint boot build by using command
# mvn clean package
#build it using
#docker build -t backend-app .
#run it using
#docker run -i -p 8000:8000 backend-app[image-name]
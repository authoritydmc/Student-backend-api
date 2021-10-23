FROM openjdk:8-alpine
RUN mkdir $HOME/web-app
WORKDIR $HOME/web-app/
COPY ./target/student-backend-1.0.jar ./

ENTRYPOINT ["java","-jar","student-backend-1.0.jar"]

#before executing docker build make sure to have latest sprint boot build by using command
# mvn clean package
#build it using
#docker build -t backend-app .
#run it using
#docker run -i -p 8000:8000 backend-app[image-name]
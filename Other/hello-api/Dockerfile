FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/demo-0.0.1-SNAPSHOT.jar hello.jar
ENTRYPOINT  ["java", "-jar", "hello.jar"]


#BUILD AN IMAGE: docker build -f DockerFile -t hi .   (do not forget the dot, al lowercase)
#LIST IMAGES; docker images – list images
#RUN CONTAINER; docker run -p 8822:8080 -d hi 
#docker ps
#localhost:8822/hello-message
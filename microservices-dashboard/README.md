#Microservice Dashboard

This a GUI for administrating Microservice Applications.

For more info see the [spring-cloud-dashboard](https://github.com/ordina-jworks/microservices-dashboard) project.

##Quick Start
 
To compile:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/microservices-dashboard.jar
```
 
To open the Dashboard 
 
```
http://localhost:8123/
```

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```microservices-dashboard```.

```
mvn clean package
docker build -t microservices-dashboard .
```

###To run the container

The following command starts a new container named ```microservices-dashboard``` from the ```microservices-dashboard``` image. It maps port 8123 so that it can be reachable.

```
docker run -p 8123:8123 -d --name microservices-dashboard microservices-dashboard
```

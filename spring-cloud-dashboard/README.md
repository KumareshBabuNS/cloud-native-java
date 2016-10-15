#Spring Cloud Dashboard

This a GUI for administrating Spring Cloud Applications.

For more info see the [spring-cloud-dashboard](https://github.com/VanRoy/spring-cloud-dashboard) project.

##Quick Start
 
To compile:
 
```ShellSession
mvn clean package
```
 
To execute:
 
```ShellSession
java -jar target/spring-cloud-dashboard.jar
```
 
To open the Dashboard 
 
```
http://localhost:8086/
```

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```spring-cloud-dashboard```.

```
mvn clean package
docker build -t spring-cloud-dashboard .
```

###To run the container

The following command starts a new container named ```spring-cloud-dashboard``` from the ```spring-cloud-dashboard``` image. It maps port 8086 so that it can be reachable.

```
docker run -p 8086:8086 -d --name zipkin-service zipkin-service
```

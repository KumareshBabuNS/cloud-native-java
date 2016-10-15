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
java -jar target/spring-boot-admin.jar
```
 
To open the Dashboard 
 
```
http://localhost:8085/
```

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```spring-boot-admin```.

```
mvn clean package
docker build -t spring-boot-admin .
```

###To run the container

The following command starts a new container named ```spring-boot-admin``` from the ```spring-boot-admin``` image. It maps port 8085 so that it can be reachable.

```
docker run -p 8085:8085 -d --name spring-boot-admin spring-boot-admin
```

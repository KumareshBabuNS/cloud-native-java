#Redis Service

Redis is a memory database, it can be used as a static server to store temperary resource or cache resource.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/redis-service.jar
```

To test redis-service:


##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```redis-service```.

```
mvn clean package
docker build -t redis-service .
```

###To run the container

The following command starts a new container named ```redis-service``` from the ```redis-service``` image. It maps port 8099 so that it can be reachable.

```
docker run -p 8099:8099 -d --name redis-service redis-service
```

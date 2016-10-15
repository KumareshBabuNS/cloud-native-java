#Zipkin

Zipkin is a distributed tracing system, it can track the request call route and used to monitor the issue.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/zipkin-service.jar
```

To test zipkin, open browser and navigate to link: http://localhost:9411/

You should see the dashboard and select a service and search the trace.

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```zipkin-service```.

```
mvn clean package
docker build -t zipkin-service .
```

###To run the container

The following command starts a new container named ```zipkin-service``` from the ```zipkin-service``` image. It maps port 9411 so that it can be reachable.

```
docker run -p 9411:9411 -d --name zipkin-service zipkin-service
```

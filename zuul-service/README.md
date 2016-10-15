#Zuul

Zuul is a gatekeeper that uses Eureka to discover the services. It uses Ribbon to balance service calls.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/zuul-service.jar
```

To test api-reservation:

Open browser and navigate to link: http://localhost:8765/api/reservations/names

You should see something like this:

```json
{
  ["Dr. Rod","Dr. Syer","Juergen","Spencer","Phillip","ALL THE COMMUNITY","Josh"]
}
```

This Zuul server is configured to only forward calls to api service, for all backend services a 404 is returned. Example:

##Hystrix Console
    
The ```org.springframework.cloud:spring-cloud-netflix-hystrix-amqp``` has been added to the pom.xml, this means that Hystrix stream will be added to RabbitMQ so that
Turbine can aggregate it to the stream to be used in Hystrix Dashboard.

More information about Zuul can be found [here](http://projects.spring.io/spring-cloud/spring-cloud.html#_router_and_filter_zuul).

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```zuul-service```.

```
mvn clean package
docker build -t zuul-service .
```

###To run the container

The following command starts a new container named ```zuul-service``` from the ```zuul-service``` image. It maps port 8765 so that it can be reachable.

```
docker run -p 8765:8765 -d --name zuul-service zuul-service
```

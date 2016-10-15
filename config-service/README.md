#Config Service

##Introduction

This sevice will keep the configuration to be read by the micro-services. The objective is to have one centralized place to store the configuration.

##Quick Start

To compile:

```ShellSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/config-service.jar
```

##Configuration

###bootstrap.yml

This is the first file read by the application when is run. This file contains the name of the application and where to find the configuration files.

The configuration files are stored in the local file system, but it can also be stored in any git server.

###application.yml

This file contains configurations for the port in which it should run, the eureka server to use, and the Actuator management path.

##Testing

Once the server is running it can be queried by:

```ShellSession
http://localhost:8888/{name}/{env}/{label}
```

Where:

* **name** is the application name
* **env** is the profile name (default by default)
* **label** is the branch name (master by default). This is optional and can be omitted.

##Refreshing Changes

There is an endpoint in the microservices to refresh the changes in the configuration file. A POST request must be issued ```/refresh``` endpoint. 

```ShellSession
curl -X POST http://localhost:<port>/refresh
```

To refresh all services at once ```spring cloud bus``` adds a ```/bus/refresh``` endpoint to the microservices. If this endpoint is called it will send refresh message to all the
microservices via RabbitMQ. For this to work RabbitMQ must be running. For example:  

```ShellSession
curl -X POST http://localhost:<port>/bus/refresh
```

More info [here](http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html)

##Docker

Docker images can be created to test deploying the server into a different environment. The script to create the Docker image is contained in the Dockerfile.
 
###To create the image

The following commands creates the latest jar file and creates a Docker image called ```config-service```.

```
mvn clean package
docker build -t config-service .
```

###To run the container

The following command starts a new container named ```config-service``` from the ```config-service``` image. It maps port 8888 so that it can be reachable.

```
docker run -p 8888:8888 -d --name config-service config-service
```
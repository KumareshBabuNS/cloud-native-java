#
# Dockerfile for Microservice dashboard
#

FROM java:8

MAINTAINER Michael Ji

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /microservices-dashboard

ADD target/microservices-dashboard.jar microservices-dashboard.jar

RUN bash -c 'touch /microservices-dashboard.jar'

EXPOSE 8123
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "microservices-dashboard.jar"]
#
# Dockerfile for Zipkin
#

FROM java:8

MAINTAINER Michael Ji

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /zipkin

ADD target/zipkin-service.jar zipkin-service.jar

RUN bash -c 'touch /zipkin-service.jar'

EXPOSE 9411
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "zipkin-service.jar"]
#
# Dockerfile for redis service
#

FROM java:8

MAINTAINER Michael Ji

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /redis-service

ADD target/redis-service.jar redis-service.jar

RUN bash -c 'touch /redis-service.jar'

EXPOSE 8099
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "redis-service.jar"]
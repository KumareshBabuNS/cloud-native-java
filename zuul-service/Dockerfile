#
# Dockerfile for zuul
#

FROM java:8

MAINTAINER Michael Ji

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /zuul-service

ADD target/zuul-service.jar zuul-service.jar

RUN bash -c 'touch /zuul-service.jar'

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "zuul-service.jar"]
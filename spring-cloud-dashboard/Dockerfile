#
# Dockerfile for Turbine
#

FROM java:8

MAINTAINER Michael Ji

# Install netcat
RUN apt-get update && apt-get install -y netcat

VOLUME /tmp

WORKDIR /spring-cloud-dashboard

ADD target/spring-cloud-dashboard.jar spring-cloud-dashboard.jar

RUN bash -c 'touch /spring-cloud-dashboard.jar'

EXPOSE 8086
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "spring-cloud-dashboard.jar"]
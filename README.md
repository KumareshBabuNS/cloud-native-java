# cloud-native-java
This is a repository of micro-service architect by leveraging spring cloud netflix and also refer to Josh Long's cloud native java repository on Github.
 
It will include blow components:
1. auth-service : doing Oauth2 to protect the resources
2. config-service : configuration server for microservice configuration
3. eureka-service : service register and discovery
4. hystrix-dashboard : circuit breaker to make sure the service availability
5. turbine-service : aggregate the hystrix stream for distribute system
6. zipkin-service : distribute tracing
7. microservices-dashboard : dashboard for show the service relationship
8. spring-boot-admin : monitor for microservice
9. spring-cloud-dashboard : dashboard for cloud application

The purpose of this architect is to make a clear and clean framework for any micro-service platform that can be used anywhere.

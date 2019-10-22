# spring-boot-microservice

This is a sample microservice application is spring boot.
It uses the following - 
Netflix Zuul, Ribbon, OpenFeign, hystrix, eureka.

Start the applications in following order -
1. config-server
2. eureka server
3. product search service/employee search service
4. product dashboard service/employee dashboard service
5. gateway service

All the applications run on different ports for multiple replication of the modules use docker.

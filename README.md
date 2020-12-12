# RestTemplate vs WebClient

The goal of this project is to compare _WebClient_ and _RestTemplate_  in a Spring MVC application on Wildfly.

This repository contains two simple application:
 - **rest-template-vs-web-client**: Spring App that exposes two endpoints:
   - /resttemplate/samples/{id}: call the service exposed by slow-application using *RestTemplate*;
   - /webclient/samples/{id}: call the service exposed by slow-application using *WebClient*;
 - **slow-application**: a very very simple node application in order to simulate a slow app (response time 2 seconds).
   /samples/:id and return a json like this { id: 1, details : "Exmplae details"};

 ## Getting started
In order to build and run this project are required:

* Apache Maven;
* JDK 8+;
* Wildfly.

An alternative is to run the docker compose:

```
docker-compose up
```


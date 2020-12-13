# RestTemplate vs WebClient

The goal of this project is to compare _WebClient_ and _RestTemplate_  in a Spring MVC application on Wildfly.

_WebClient_ is part of the WebFlux reacive stack, but it can improve the performance of a classic application, for example a Spring MVC application on Wildfly.

This repository contains two simple application:
 - **rest-template-vs-web-client**: Spring App that exposes two endpoints:
   - _/resttemplate/samples/{id}_: call the service exposed by slow-application using *RestTemplate*;
   - _/webclient/samples/{id}_: call the service exposed by slow-application using *WebClient*;
 - **slow-application**: a very simple node application in order to simulate a slow app (response time 2 seconds).
    - _/samples/:id_ and return a json like this { id: 1, details : "Exmplae details"};

 ## Getting started
In order to build and run this project are required:

* Apache Maven;
* JDK 8+;
* Wildfly;
* Node.

An alternative is to run the docker compose:

```
docker-compose up
```

## Test

You can compare the two modules with _Apache Bench_:

1. RestTemplate
    ```
    ab -n 5000 -c 500 http://127.0.0.1:8080/rest-template-vs-web-client/api/resttemplate/samples/7
    ```

1. Webclient
    ```
    ab -n 5000 -c 500 http://127.0.0.1:8080/rest-template-vs-web-client/api/webclient/samples/7
    ```



# The Player APP
This API is meant for a demo using CircleCI, JIB, Docker, GCP, Kubernetes

This java microservice was generated using https://start.spring.io/ and it's based on spring-boot-starter-web


In the player-api project you will find:
* the parent pom.xml
* the microservice sub-project
* the integration test sub-project

To run the server locally, just start the PlayerApiApplication from the microservice/test project. Then it is possible to run
the integrated test suite by running the PlayerApiIntegrationTest from the test sub-project. Beforehand, you need to configure
those variable:
-DbaseURI=http://localhost -Dport=8080 -DbasePath=/


## Setting up continous integration using CircleCI

## Creating the Dockerfile

## Setting up Google Kubernetes Engine

## Deploying  to GKE

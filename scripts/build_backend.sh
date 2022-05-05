#!/usr/bin/env bash

# clean up
mvn clean
# install dependencies and build jar
mvn install
# build backend docker image
docker build -t dhakadb/spring-boot-app:latest .
# push docker image to docker hub
docker push dhakadb/spring-boot-app:latest
# restart deployment
kubectl rollout restart deployment spring-boot-app-deployment
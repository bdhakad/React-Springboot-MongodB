#!/usr/bin/env bash

# clean up
mvn clean
# install dependencies and build jar
mvn install
# build backend docker image
docker build -t spring-boot-docker:latest .
#!/usr/bin/env bash

# build frontend app
scripts/build_frontend.sh

# build backend app
scripts/build_backend.sh

# clean up dangling images
docker rmi $(docker images -f "dangling=true" -q) --force

# deploy app
docker-compose -f docker-compose.yml up
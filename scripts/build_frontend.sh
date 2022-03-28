#!/usr/bin/env bash

# change to frontend directory
cd frontend
# install dependencies
npm install
# build frontend
npm run build
# build frontend docker image
docker build -t react-frontend:latest .
#!/usr/bin/env bash

# change to frontend directory
cd frontend
# install dependencies
npm install
# build frontend
npm run build

# build frontend docker image
docker build -t dhakadb/react-frontend:latest .
docker push dhakadb/react-frontend:latest

# optimised production build
# docker build -f Dockerfile.prod -t dhakadb/react-frontend:stable .
# docker push dhakadb/react-frontend:stable

kubectl rollout restart deployment react-frontend-deployment
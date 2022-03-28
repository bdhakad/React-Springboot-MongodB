# React-Springboot-MongodB

## Build and Deploy the app to docker engine aka Docker Dekstop in local machine
Go to root directory and run below script
```
    sh script/build_n_run.sh 
```

The react app will be served on 
```
    localhost:3000
```


## Build only the frontend 
```
    sh script/build_frontend.sh
```


## Build only the backend 
```
    sh script/build_backend.sh
```


## Run  using docker-compose
 * build spring-boot either by running the `mvn install`
 * build the frontend react app by running ` npm install && npm run build`
 * build the docker images for both react app and sring-boot app. The build scripts inside script folder will do it for if you use them.
 * Once both the images are built, change the image names, port, env etc in `docker-compose.yml` file.
 * In this case I have added two more images to the compose file i.e. mongo and mongo-express. This will create a mongodb instance and the corresponding mongo-express to view the database from UI.
 * mongo-express will mostly available on port `8081` and mongodb at `27017`.
 * Once done with all the steps just run 
 ```
     docker compose -f docker-compose.yml up
 ```



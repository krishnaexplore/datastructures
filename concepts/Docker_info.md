# Docker
- Docker is an open platform for developing, shipping, and running applications.
- Treat your infrastructure like a ** Manage Application **
	** for example if want to run java web application, need to have OS, JAVA (JRE), web server (e.g. tomcat) to run your web application. bundle all these into one package (image) push to prod server (hardware)

- shorten the cycle between writing code and running code.
- Docker does this by combining kernel containerization features with workflows and tooling

##Docker components

- Docker images : blue prints of our application.
- Docker Container : created from docker image and a real instance of our application.
- Docker Daemon : building, running and distributing docker containers.
- Docker client : run on our local machine and connect to the daemon.
- Docker hub : A registry of docker images

## commands

- Create image using this directory's Dockerfile   `docker build -t friendlyname`
- Run "friendlyname" mapping port 4000 to 80       `docker run -p 4000:80 friendlyname`
- Same thing, but in detached mode                 `docker run -d -p 4000:80 friendlyname`
- See a list of all running containers             `docker ps`
- Gracefully stop the specified container          `docker stop <hash>`
- See a list of all containers, even the ones not running `docker ps -a`
- Force shutdown of the specified container     `docker kill <hash>`
- Remove the specified container from this machine   `docker rm <hash>`
- Remove all containers from this machine `docker rm $(docker ps -a -q)` 
- Show all images on this machine `docker images -a`
- Remove the specified image from this machine      `docker rmi <imagename>`
- Remove all images from this machine `docker rmi $(docker images -q)`
- Log in this CLI session using your Docker credentials `docker login`
- Tag <image> for upload to registry `docker tag <image> username/repository:tag`
- Upload tagged image to registry `docker push username/repository:tag`
- Run image from a registry `docker run username/repository:tag`
- List all running applications on this Docker host `docker stack ls`
- Run the specified Compose file `docker stack deploy -c <composefile> <appname>`
- List the services associated with an app `docker stack services <appname>`
- List the running containers associated with an app `docker stack ps <appname>`
- Tear down an application `docker stack rm <appname>`  

- `docker tag friendlyhello kgangaraju/krepository:mtag`
- `docker push kgangaraju/krepository:mtag`
 
- how to copy files from container to host system
`docker cp <containerId>:/file/path/within/container /host/path/target`
- Answer from stackoverflow [stackOverflow answer](https://stackoverflow.com/questions/22049212/docker-copy-file-from-container-to-host). 
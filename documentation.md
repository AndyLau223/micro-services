
# docker images commands 

docker images --> list all the local images

docker tag repo/image_name tag_name ---> add tag for a image 

docker pull image_name ---> pull an image from docker repository

docker search image_name ---> search an image on remote repository



# docker container

docker container run -p local_port:docker_port repo_name


docker container pause docker_container_id(can be partial)

docker container unpause docker_container_id

docker container inspect 

docker container ls -a 

docker container stop docker_container_id --> graceful shutdown 

docker container kill docker_container_id --> shutdown immediately even though there's threads running.

docker container prune -->removes all stopped containers.



# other docker commands 

docker events ---> open monitoring windows showing real-time event of docker

docker stats ---> shows all stats regarding the containers which's running

docker top c710

docker run -m 512m --cpu-quota 50000
docker system df

# distributed tracing using Docker 

docker run -p 9411:9411 openzipkin/zipkin:2.23

By default, sring.zipkin.baseurl=http:localhost:9411/, so that we simply add the dependency into pom.xml, it works fine.

# VERSION 0.1
# DOCKER-VERSION  0.7.3
# AUTHOR:         yubing/wcw/Owen <yubing744@163.com>
# DESCRIPTION:    Image with deal-file-server project and dependecies
# TO_BUILD:       docker build -t deal-file-server .
# TO_RUN:         docker run -P deal-file-server

# Latest frolvlad/alpine-oraclejdk8:slim
FROM frolvlad/alpine-oraclejdk8:slim

# Project path
ENV PROJECT_PATH=/kuick/servers

# Set localtime
COPY ./release/docker/localtime /etc/localtime
ENV JAVA_OPTS="-Duser.timezone=GMT+8"

# Set tmp
VOLUME /tmp

# Workdir
WORKDIR $PROJECT_PATH

# Expose port
#EXPOSE 8080

#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar ./app.jar"]


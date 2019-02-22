# VERSION 0.1
# DOCKER-VERSION  0.7.3
# AUTHOR:         pan/liu <liupan7891@yeah.net>
# DESCRIPTION:    
# TO_BUILD:       docker build -t 
# TO_RUN:         docker run -P 

# Latest frolvlad/alpine-oraclejdk8:slim
FROM frolvlad/alpine-oraclejdk8:slim

# Project path
ENV PROJECT_PATH=/leetcode/servers

# Set localtime
COPY ./release/docker/localtime /etc/localtime
ENV JAVA_OPTS="-Duser.timezone=GMT+8"

# Set tmp
VOLUME /tmp

# Workdir
WORKDIR $PROJECT_PATH

# Expose port
#EXPOSE 8080

#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar ./leetcode.jar"]


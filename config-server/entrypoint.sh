#!/bin/bash

java -Duser.timezone=$TZ $JAVA_OPTS -jar "$1" \
     --spring.cloud.config.server.git.uri="$GIT_URI" \
     --spring.cloud.config.server.git.searchPaths="$GIT_SEARCH_PATHS" \
     --eureka.client.serviceUrl.defaultZone="$EUREKA_SERVICE_URL"
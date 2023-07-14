#!/bin/bash

if [ -n "$PROXY_HOST" ] && [ -n "$PROXY_PORT" ]; then
  set -- \
    "$@" \
    "--spring.cloud.config.server.git.proxy.https.host=$PROXY_HOST" \
    "--spring.cloud.config.server.git.proxy.https.port=$PROXY_PORT" \
    "--spring.cloud.config.server.git.proxy.http.host=$PROXY_HOST" \
    "--spring.cloud.config.server.git.proxy.http.port=$PROXY_PORT"
fi

java -Duser.timezone=$TZ $JAVA_OPTS -server -jar "/config-server-1.0-SNAPSHOT.jar" \
     --spring.cloud.config.server.git.uri="$GIT_URI" \
     --spring.cloud.config.server.git.searchPaths="$GIT_SEARCH_PATHS" \
     --eureka.client.serviceUrl.defaultZone="$EUREKA_SERVICE_URL" \
     "$@"
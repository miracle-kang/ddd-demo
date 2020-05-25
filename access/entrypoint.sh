#!/bin/bash

java -Duser.timezone=$TZ $JAVA_OPTS -jar "$1" \
     --spring.cloud.config.uri="$CONFIG_URI" \
     --eureka.client.serviceUrl.defaultZone="$EUREKA_SERVICE_URL"
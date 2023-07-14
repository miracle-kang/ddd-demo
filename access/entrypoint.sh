#!/bin/bash

if [ -n "$MYSQL_URL" ] && [ -n "$MYSQL_DATABASE" ]; then
  set -- \
    "$@" \
    "--spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver" \
    "--spring.datasource.url=jdbc:$MYSQL_URL/$MYSQL_DATABASE?useUnicode=true&characterEncoding=utf-8&characterSetResults=utf-8&createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true"
fi
if [ -n "$MYSQL_USER" ] && [ -n "$MYSQL_PASSWORD" ]; then
  set -- \
    "$@" \
    "--spring.datasource.username=$MYSQL_USER" \
    "--spring.datasource.password=$MYSQL_PASSWORD"
fi

java -Duser.timezone=$TZ $JAVA_OPTS -server -jar "/access-1.0-SNAPSHOT.jar" \
     --spring.cloud.config.uri="$CONFIG_URI" \
     --eureka.client.serviceUrl.defaultZone="$EUREKA_SERVICE_URL" \
     --spring.zipkin.base-url="$ZIPKIN_BASE_URL" \
     "$@"
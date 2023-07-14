FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/config-server-1.0-SNAPSHOT.jar /

EXPOSE  8888
ENTRYPOINT  ["sh", "/entrypoint.sh"]

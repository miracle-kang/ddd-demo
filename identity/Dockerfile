FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/identity-1.0-SNAPSHOT.jar /

EXPOSE  30001
ENTRYPOINT  ["sh", "/entrypoint.sh"]

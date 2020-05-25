FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/access-1.0-SNAPSHOT.jar /

EXPOSE  30002
ENTRYPOINT  ["sh", "/entrypoint.sh"]
CMD     ["/access-1.0-SNAPSHOT.jar"]
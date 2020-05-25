FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/api-gateway-1.0-SNAPSHOT.jar /

EXPOSE  8080
ENTRYPOINT  ["sh", "/entrypoint.sh"]
CMD     ["/api-gateway-1.0-SNAPSHOT.jar"]
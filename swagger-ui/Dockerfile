FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/swagger-ui-1.0-SNAPSHOT.jar /

EXPOSE  8081
ENTRYPOINT  ["sh", "/entrypoint.sh"]
CMD     ["/swagger-ui-1.0-SNAPSHOT.jar"]
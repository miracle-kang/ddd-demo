FROM    openjdk:14-alpine

COPY    entrypoint.sh /
COPY    target/service-registry-1.0-SNAPSHOT.jar /

EXPOSE  8761
ENTRYPOINT  ["sh", "/entrypoint.sh"]
CMD     ["/service-registry-1.0-SNAPSHOT.jar"]
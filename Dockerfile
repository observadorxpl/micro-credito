FROM openjdk:8
VOLUME /tmp
ADD ./target/ProductosCreditosMS-0.0.1-SNAPSHOT.jar micro-credito.jar
ENTRYPOINT ["java","-jar","/micro-credito.jar"]
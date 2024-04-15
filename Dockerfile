FROM openjdk:22
VOLUME /tmp
EXPOSE 8080
ADD target/Employee-system.jar Employee-system.jar
ENTRYPOINT ["java","-jar","/Employee-system.jar"]
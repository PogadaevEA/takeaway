FROM openjdk:11
ADD build/libs/takeaway-0.0.1.jar takeaway-0.0.1.jar
COPY src/main/resources/db/changelog/2021.01.01_base.sql /docker-entrypoint-initdb.d/10-init.sql
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "takeaway-0.0.1.jar"]
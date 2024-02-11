FROM maven AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/

RUN mvn package spring-boot:repackage

FROM amazoncorretto:17-alpine
EXPOSE 8080
COPY --from=maven_build /tmp/target/adoteumpet-0.0.1-SNAPSHOT.jar /usr/local/lib/adoteumpet.jar
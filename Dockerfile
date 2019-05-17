FROM maven as server-build
WORKDIR /build
COPY . . 
RUN mvn clean install
FROM java:8
COPY --from=server-build build/target/independent_project-0.0.1-SNAPSHOT.jar independent-project.jar
EXPOSE 8081
ENTRYPOINT ["/usr/bin/java", "-jar", "independent-project.jar"]

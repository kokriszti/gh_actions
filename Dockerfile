FROM eclipse-temurin:11
RUN mkdir /opt/app
COPY target/github_actions_test-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/github_actions_test-0.0.1-SNAPSHOT.jar"]
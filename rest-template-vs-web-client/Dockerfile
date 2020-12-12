#
# Build stage
#
FROM maven:3.5.3-jdk-8 as workspace

COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean package

#
# Deploy & Run stage
#
FROM jboss/wildfly:21.0.1.Final

# Copy the war file to the deployments folder
COPY --from=workspace /home/app/target/rest-template-vs-web-client.war /opt/jboss/wildfly/standalone/deployments/rest-template-vs-web-client.war


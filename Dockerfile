FROM maven:3.3-jdk-8 AS builder
WORKDIR /usr/src/mymaven
COPY . .
RUN mvn package -DskipTests=true

FROM tomcat:10-jdk8-openjdk-slim-buster 
COPY --from=builder /usr/src/mymaven/target/demo.war /usr/local/tomcat/webapps/demo.war
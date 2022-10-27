# Workshop java web tdd :: 2022/10/27...

How to run?
```
$mvnw clean test
$mvnw cobertura:cobertura
$mvnw package -DskipTests=true
$mvnw tomcat7:run
```

เข้าใช้งานที่ url http://localhost:8080/demo

## Run with Docker
```
$docker container run -it --rm --name my-maven-project \
  -v "$(pwd)":/usr/src/mymaven \
  -w /usr/src/mymaven maven:3.3-jdk-8 mvn package -DskipTests=true

$docker container run -d --name web-tomcat \
   -v "$(pwd)/target/demo.war":/usr/local/tomcat/webapps/demo.war \
   -p 9999:8080 tomcat:10.0.7-jdk8-openjdk-slim-buster
```

## Create Docker image with multi-stage build
```
$docker image build -t java-demo .
$docker container run -d -p 9898:8080 java-demo
```

Deploy to server
```
$docker container rm -f somkiat
$docker container run -d --name somkiat -p 8888:8080 -v $(pwd):/usr/local/tomcat/webapps/ tomcat:8.0-alpine
```

Working with SonarQube
```
$./mvnw sonar:sonar \
 -Dsonar.host.url=http://128.199.199.84:9000 \
 -Dsonar.projectKey=pui \
 -Dsonar.projectName=pui \
 -Dsonar.login=admin \
 -Dsonar.password=password \
 -Dsonar.java.binaries=target/classes
```

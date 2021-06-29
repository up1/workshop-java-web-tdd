# Workshop java web tdd

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
```

Deploy to server
```
$docker container rm -f somkiat
$docker container run -d --name somkiat -p 8888:8080 -v $(pwd):/usr/local/tomcat/webapps/ tomcat:8.0-alpine
```

Working with SonarQube
```
$mvnw sonar:sonar 
-Dsonar.host.url=http://10.10.99.82:9000 
-Dsonar.projectKey=pui 
-Dsonar.projectName=pui
```

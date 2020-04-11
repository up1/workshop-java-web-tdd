# workshop-java-web-tdd

How to run?
```
$mvnw clean test
$mvnw package -DskipTests=true
$mvnw cobertura:cobertura
$mvnw tomcat7:run
```

เข้าใช้งานที่ url http://localhost:8080/demo

Working with SonarQube
```
$mvnw sonar:sonar 
-Dsonar.host.url=http://10.10.99.82:9000 
-Dsonar.projectKey=pui 
-Dsonar.projectName=pui
```


XXX

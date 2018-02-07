pipeline {
  node {
     stages {
       stage('Pullcode') {
         git 'https://github.com/up1/workshop-java-web-tdd.git'
       }
       stage('Testing') {
          sh "mvn clean test"
          junit 'target/surefire-reports/*.xml'
        }
        stage('Package') {
          sh "mvn package"
        }
        stage('Code coverage') {
          cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false
        }
      }
      post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
   }
}

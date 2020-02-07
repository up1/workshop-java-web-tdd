pipeline {
     agent any
     stages {
       stage('Pullcode') {
         steps {
             git 'https://github.com/up1/workshop-java-web-tdd.git'
         }
       }
       stage('Testing') {
          steps {
            sh "mvnw clean test"
            junit 'target/surefire-reports/*.xml'
          }
        }
        stage('Code coverage') {
          steps {
             sh "mvnw cobertura:cobertura"
             cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false
          }
        }
        stage('Package') {
          steps { 
            sh "mvnw package -DskipTests=true"
          }
        }
      }
      post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
      }
}

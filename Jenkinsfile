pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        bat 'mvn clean -f spring-boot/pom.xml'
        bat 'mvn compile -f spring-boot/pom.xml'
      }
    }
    stage('package') {
      steps {
        bat 'mvn package -f spring-boot/pom.xml'
      }
    }
  }
}
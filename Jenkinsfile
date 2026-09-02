pipeline {
 agent any
  tools {
 maven 'maven-3.9'
 }
parameters {
 string(
 name: 'VERSION',
 defaultValue: '',
 description: 'version to deploy'
 )
 choice(
 name: 'ENVIRONMENT',
 choices: ['dev', 'staging', 'prod']
 )
 booleanParam(
 name: 'executeTests',
 defaultValue: true
 )
}

 environment {
 NEW_VERSION = '1.3.0'
 }
  stages {
   stage('Build') {
     steps { echo "building the application ${NEW_VERSION}..." }
    }
   stage('Test') {
     when {
       expression {
      params.executeTests
     }
    }
     steps { echo 'testing the application...' }
    }

   
   stage('Deploy') {
    steps {
      withCredentials([
      usernamePassword(
          credentialsId: 'server-credentials',
          usernameVariable: 'USER',
          passwordVariable: 'PWD'
          )
      ]) {
       echo " ${USER} ${PWD} "
       echo 'deploying the application...'
       echo "Deploying version ${params.VERSION}"
       echo "Target: ${params.ENVIRONMENT}"
 }
    }
  }
  }
 post {
 always { echo 'This always runs' }
 success { echo 'The pipeline succeeded' }
 failure { echo 'The pipeline failed' }
 }
}

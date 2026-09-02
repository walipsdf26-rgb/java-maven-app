pipeline {
 agent any
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
      env.BRANCH_NAME == 'dev'
     }
    }
     steps { echo 'testing the application...' }
    }
   stage('Deploy') {
    steps { echo 'deploying the application...' }
   }
  }
 post {
 always { echo 'This always runs' }
 success { echo 'The pipeline succeeded' }
 failure { echo 'The pipeline failed' }
 }
}

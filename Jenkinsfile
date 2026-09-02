pipeline {
 agent any
  stages {
   stage('Build') {
     steps { echo 'building the application...' }
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

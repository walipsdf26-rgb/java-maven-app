def gv
pipeline {
 agent any
 stages {
 stage('Init') {
 steps {
 script {
 gv = load 'script.groovy'
 }
 }
 }
 stage('Build') {
 steps { script { gv.buildApp() } }
 }
  stage('Deploy') {
 input {
 message 'Select the environment to deploy to'
 ok 'Done'
 parameters {
 choice(
 name: 'ENV',
 choices: ['dev', 'staging', 'prod']
 )
 }
 }
 steps {
 script { gv.deployApp() }
 echo "Deploying to ${ENV}"
 }
}
 }

}

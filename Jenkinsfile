def gv
pipeline {
  agent any
  tools { maven 'maven-3.9' }
  stages {
    stage('Init') {
      steps { script { gv = load 'script.groovy' } }
    }
    stage('Build JAR') {
      steps { script { gv.buildJar() } }
    }
    stage('Build image') {
      steps { script { gv.buildImage() } }
    }
    stage('Deploy') {
      steps { script { gv.deployApp() } }
    }
  }
}

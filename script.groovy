def buildJar() {
  sh 'mvn package'
}

def buildImage() {
  echo 'deploying the application...'
  sh 'docker build -t waqassaleem/java-maven-app:1.0 .'
}

def deployApp() {
  withCredentials([
    usernamePassword(
      credentialsId: 'server-credentials',
      usernameVariable: 'USER',
      passwordVariable: 'PASS'
    )
  ]) {
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push waqassaleem/java-maven-app:1.0'
  }
}

return this

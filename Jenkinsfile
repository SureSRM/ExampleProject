pipeline {
  // agent {
  //   docker {
  //     image "maven:3.5.0-jdk-8-alpine"
  //     reuseNode true
  //   }
  // }
  agent {
    label 'docker'
  }

  stages {
    stage('build-jar') {
      steps {
        sh "./mvnw package -DskipTests -Ddockerfile.skip"
      }
    }

    stage('unit-test') {
      steps {
        sh "./mvnw test"
      }
    }

    stage('build-images') {
      steps {
        sh "docker version"
        sh "./mvnw package -DskipTests"
      }
    }

    stage('integration-test') {
      steps {
        sh "docker-compose version"
      }
    }

    // stage('deploy') {
    //   agent {
    //     docker {
    //       image "maven:3.5.0-jdk-8-alpine"
    //       args "-e "
    //     }
    //   }
    //   environment {
    //     REGISTRY_USER=credentials('agent-docker-registry-user')
    //     REGISTRY_PASSWORD=credentials('agent-docker-registry-password')
    //   }
    //   steps {
    //     sh "echo "
    //   }
    // }

  }

  post {
    always {
      sh "echo --end--"
    }
  }
}

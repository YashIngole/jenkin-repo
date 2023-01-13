pipeline {
    agent any
    stages {
        stage("code pull"){
            steps {
                git branch: 'main', credentialsId: 'git_hub_creds' , url:
                            }
        }
        stage('build')
        steps {
           sh 'mvn clean package'
        }
        }
    }

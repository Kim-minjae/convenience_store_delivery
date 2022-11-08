pipeline {
    agent any
    stages{
        stage('Git Clone'){
            steps {
                sh 'echo cloning source code from git repository'
            }
        }
        stage('Maven build'){
            steps {
                sh 'echo application build and package from source build'
            }
        }
        stage('Docker build'){
            steps {
                sh 'echo build docker image'
            }
        }
        stage('Push into registry'){
            steps {
                sh 'echo push docker image to registry'
            }
        }
    } 
}

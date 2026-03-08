pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Prasanna2002/calculator-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
    post {
        success {
            echo 'Build successful! Artifact created in target/'
        }
    }
}
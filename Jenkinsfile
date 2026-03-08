pipeline {
    agent any

    triggers {
        githubPush()
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
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
        always {
            // This ensures JUnit results are visible in the Jenkins UI
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            mail to: 'prasannakumarm024@gmail.com',
                 subject: "Success: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Great job! The build and tests passed. Check it out at ${env.BUILD_URL}"
        }
        failure {
            mail to: 'prasannakumarm024@gmail.com',
                 subject: "Failure: Pipeline ${currentBuild.fullDisplayName}",
                 body: "Something went wrong. Please check the console output at ${env.BUILD_URL}"
        }
    }
}
pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = 'prasanna07e'
        IMAGE_NAME = 'scientific-calculator'
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }
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
        stage('Docker Build & Push') {
            steps {
                script {
                    // Build the image
                    sh "docker build -t ${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG} ."
                    sh "docker tag ${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                    
                    // Log in and push
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                        sh "echo \$DOCKER_HUB_PASSWORD | docker login -u \$DOCKER_HUB_USERNAME --password-stdin"
                        sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
                        sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest" 
                    }
                } 
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
        
pipeline {
    agent any
    stages 
    {
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
        //checking
        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t prasanna07e/calculator-app_m:latest  ."
                } 
            } 
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', 
                                 passwordVariable: 'DOCKER_HUB_PASSWORD', 
                                 usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    
                    sh "echo ${DOCKER_HUB_PASSWORD} | docker login -u ${DOCKER_HUB_USERNAME} --password-stdin"
                    
                    sh "docker push prasanna07e/calculator-app_m:latest"
                    
                }
            }
        }
        stage('Deploy to Environment') {
            steps {
                script {
                    sh "ansible-playbook -i deploy/inventory.ini deploy/sci_calci.yml"
                }
                
                //ansiblePlaybook(
                  //  playbook: 'deploy/sci_calci.yml',
                    //inventory: 'deploy/inventory.ini',
                ///)
            }
        }
    }

    post {
        //commenting
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        // success {
        //     mail to: 'prasannakumarm024@gmail.com',
        //          subject: "Success: Pipeline ${currentBuild.fullDisplayName}",
        //          body: "Great job! The build and tests passed. Check it out at ${env.BUILD_URL}"
        // }
        // failure {
        //     mail to: 'prasannakumarm024@gmail.com',
        //          subject: "Failure: Pipeline ${currentBuild.fullDisplayName}",
        //          body: "Something went wrong. Please check the console output at ${env.BUILD_URL}"
        // }
    } 
}
        
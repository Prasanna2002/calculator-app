

pipeline {
    agent any
    
    tools {
        // This must match the 'Name' you gave Maven in 
        // Manage Jenkins -> Global Tool Configuration
        maven 'Maven 3' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Explicitly defining the branch helps avoid detection issues
                git branch: 'main', url: 'https://github.com/Prasanna2002/calculator-SPE.git'
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
    }
}
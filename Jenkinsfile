pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout stage has started'
                git 'https://github.com/Anastasia-Ger/SelCucPet-project.git'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Tests stage has started'
                bat 'mvn clean test'
            }
        }       
    }
    
}

pipeline {
	agent any
	tools {
		maven 'maven 3.8.1'
		jdk 'JDK 11'
	}
	stages {
		stage('Checkout') {
			steps {
			    echo 'Checkout stage has started'
				git 'https://github.com/Anastasia-Ger/SelCucPet-project.git'
			}
		}
		stage('Build and Test') {
			steps {
			echo 'Building and testing stage has started'
			sh 'mvn clean test'
			}
		}
	}
	post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
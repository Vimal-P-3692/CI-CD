pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                dir('/home/ec2-user/CI-CD') {
                    sh 'git pull origin main'
                }
            }
        }

        stage('Build') {
            steps {
                dir('/home/ec2-user/CI-CD') {
                    sh './gradlew build --no-daemon'
                }
            }
        }

        stage('Test') {
            steps {
                dir('/home/ec2-user/CI-CD') {
                    sh './gradlew test --no-daemon'
                }
            }
        }

        stage('Restart Service') {
            steps {
                sh 'sudo systemctl restart myapp'
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed. Check console output for details."
        }
    }
}
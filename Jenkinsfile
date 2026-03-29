pipeline {
    agent any

    stages {

        stage('Pull Code From Git') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                git pull origin main
                '''
            }
        }

        stage('Build Code') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                ./gradlew clean build
                '''
            }
        }

        stage('Test Code') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                ./gradlew test
                '''
            }
        }

        stage('Restart Service') {
            steps {
                sh '''
                sudo systemctl restart myapp
                '''
            }
        }
    }
}
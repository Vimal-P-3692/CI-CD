pipeline {
    agent any

    stages {

        stage('Pull Latest Code') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                git reset --hard
                git clean -fd
                git pull origin main
                '''
            }
        }

        stage('Build JAR') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                ./gradlew build --no-daemon
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh '''
                cd /home/ec2-user/CI-CD
                ./gradlew test --no-daemon
                '''
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
            echo "Pipeline completed successfully and service restarted!"
        }
        failure {
            echo "Pipeline failed. Check console output for details."
        }
    }
}
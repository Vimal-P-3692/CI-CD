pipeline {
    agent any

    environment {
        APP_DIR = '/home/ec2-user/CI-CD'  // Your existing project directory
    }

    stages {

        stage('Pull Code From Git') {
            steps {
                dir("${APP_DIR}") {
                    sh '''
                    # Pull latest code
                    git reset --hard
                    git clean -fd
                    git pull origin main
                    '''
                }
            }
        }

        stage('Build') {
            steps {
                dir("${APP_DIR}") {
                    sh './gradlew build --no-daemon'
                }
            }
        }

        stage('Test Code') {
            steps {
                dir("${APP_DIR}") {
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
            echo "Pipeline failed. Check the logs for details."
        }
    }
}
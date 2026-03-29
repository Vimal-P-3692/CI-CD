pipeline {
    agent any

    environment {
        APP_DIR = '/home/ec2-user/CI-CD'  // Your project directory
    }

    stages {

        stage('Prepare Workspace') {
            steps {
                // Make sure the project directory exists and Jenkins can access it
                sh """
                mkdir -p $APP_DIR
                sudo chown -R jenkins:jenkins $APP_DIR
                chmod -R 755 $APP_DIR
                """
            }
        }

        stage('Pull Code From Git') {
            steps {
                dir("${APP_DIR}") {
                    sh '''
                    if [ -d ".git" ]; then
                        git reset --hard
                        git clean -fd
                        git pull origin main
                    else
                        git clone https://github.com/Vimal-P-3692/CI-CD.git .
                    fi
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
                // Restart your service (requires Jenkins user sudo permissions)
                sh 'sudo systemctl restart myapp'
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed. Check logs for details."
        }
    }
}
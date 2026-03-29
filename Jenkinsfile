pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'main']],
                          userRemoteConfigs: [[url: 'https://github.com/Vimal-P-3692/CI-CD.git']]
                ])
            }
        }

        stage('Build') {
            steps {
                dir("${WORKSPACE}") {
                    sh './gradlew build --no-daemon'
                }
            }
        }

        stage('Test') {
            steps {
                dir("${WORKSPACE}") {
                    sh './gradlew test --no-daemon'
                }
            }
        }

        stage('Deploy to Server Directory') {
            steps {
                sh '''
                sudo cp ${WORKSPACE}/build/libs/*.jar /home/ec2-user/CI-CD/
                sudo chown ec2-user:ec2-user /home/ec2-user/CI-CD/*.jar
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
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed. Check console output for details."
        }
    }
}
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
                    sh './gradlew clean build --no-daemon'
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
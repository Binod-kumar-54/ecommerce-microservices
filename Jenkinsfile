
pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = 'binodkar'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code checked out from GitHub'
            }
        }

        stage('Build Product Service') {
            steps {
                dir('product-service') {
                    bat 'mvnw.cmd clean package -DskipTests'
                }
            }
        }

        stage('Build Order Service') {
            steps {
                dir('order-service') {
                    bat 'mvnw.cmd clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                dir('product-service') {
                    bat "docker build -t ${DOCKERHUB_USERNAME}/product-service:${BUILD_NUMBER} -t ${DOCKERHUB_USERNAME}/product-service:latest ."
                }

                dir('order-service') {
                    bat "docker build -t ${DOCKERHUB_USERNAME}/order-service:${BUILD_NUMBER} -t ${DOCKERHUB_USERNAME}/order-service:latest ."
                }
            }
        }

        stage('Push Images to Docker Hub') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-credentials',
                        usernameVariable: 'DOCKERHUB_USER',
                        passwordVariable: 'DOCKERHUB_TOKEN'
                    )
                ]) {
                    bat 'powershell -NoProfile -Command "$env:DOCKERHUB_TOKEN | docker login --username $env:DOCKERHUB_USER --password-stdin"'

                    bat "docker push ${DOCKERHUB_USERNAME}/product-service:${BUILD_NUMBER}"
                    bat "docker push ${DOCKERHUB_USERNAME}/product-service:latest"

                    bat "docker push ${DOCKERHUB_USERNAME}/order-service:${BUILD_NUMBER}"
                    bat "docker push ${DOCKERHUB_USERNAME}/order-service:latest"
                }
            }
        }
    }
}

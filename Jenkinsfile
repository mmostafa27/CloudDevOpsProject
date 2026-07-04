@Library('shared-library') _

pipeline {
    agent any

    environment {
        IMAGE_NAME = 'ivolve-app'
        ECR_URL = '093796421953.dkr.ecr.us-east-1.amazonaws.com'
        REGION = 'us-east-1'
        REPO_URL = 'https://github.com/mmostafa27/CloudDevOpsProject.git'
    }

    stages {
        stage('Build Image') {
            steps {
                buildImage(IMAGE_NAME)
            }
        }

        stage('Scan Image') {
            steps {
                scanImage(IMAGE_NAME)
            }
        }

        stage('Push Image') {
            steps {
                pushImage(IMAGE_NAME, ECR_URL, REGION)
            }
        }

        stage('Delete Image Locally') {
            steps {
                deleteImage(IMAGE_NAME, ECR_URL)
            }
        }

        stage('Update Manifests') {
            steps {
                updateManifests(IMAGE_NAME, ECR_URL)
            }
        }

        stage('Push Manifests') {
            steps {
                pushManifests(REPO_URL)
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}

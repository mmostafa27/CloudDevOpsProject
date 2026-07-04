def call(String imageName, String ecrUrl, String region) {
    withCredentials([
        string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'),
        string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
    ]) {
        sh """
            export AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID}
            export AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY}
            aws ecr get-login-password --region ${region} | \
            docker login --username AWS --password-stdin ${ecrUrl}
            docker tag ${imageName} ${ecrUrl}/${imageName}:${BUILD_NUMBER}
            docker push ${ecrUrl}/${imageName}:${BUILD_NUMBER}
        """
    }
}

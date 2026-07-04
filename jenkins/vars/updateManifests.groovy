def call(String imageName, String ecrUrl) {
    withCredentials([
        string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'),
        string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
    ]) {
        sh """
            export AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID}
            export AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY}
            sed -i 's|image:.*|image: ${ecrUrl}/${imageName}:${BUILD_NUMBER}|' kubernetes/deployment.yml
        """
    }
}

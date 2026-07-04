def call(String repoUrl) {
    withCredentials([
        usernamePassword(
            credentialsId: 'github-credentials',
            usernameVariable: 'GIT_USERNAME',
            passwordVariable: 'GIT_PASSWORD'
        )
    ]) {
        sh """
            git config user.email "jenkins@ivolve.com"
            git config user.name "Jenkins"
            git add kubernetes/deployment.yml
            git commit -m "Update image tag to build ${BUILD_NUMBER}"
            git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/mmostafa27/CloudDevOpsProject.git main
        """
    }
}

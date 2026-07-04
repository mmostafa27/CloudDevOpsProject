def call(String repoUrl) {
    sh """
        git config user.email "jenkins@ivolve.com"
        git config user.name "Jenkins"
        git add kubernetes/deployment.yml
        git commit -m "Update image tag to build ${BUILD_NUMBER}"
        git push ${repoUrl} main
    """
}

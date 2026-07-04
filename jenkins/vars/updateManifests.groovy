def call(String imageName, String ecrUrl) {
	sh """
		sed -i 's|image:.*|image: ${ecrUrl}/${imageName}:${BUILD_NUMBER}|' kubernetes/deployment.yml 
	"""

}

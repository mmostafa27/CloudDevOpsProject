def call(String imageName, String ecrUrl) {
	sh """
		docker rmi ${imageName}
		docker rmi ${ecrUrl}/${imageName}:${BUILD_NUMBER} 
	"""
}

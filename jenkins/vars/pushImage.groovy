def call(String imageName, String ecrUrl, String region) {
	sh """
		aws ecr get-login-password --region ${region} | \
        	docker login --username AWS --password-stdin ${ecrUrl}
        	docker tag ${imageName} ${ecrUrl}/${imageName}:${BUILD_NUMBER}
        	docker push ${ecrUrl}/${imageName}:${BUILD_NUMBER}


	"""



}

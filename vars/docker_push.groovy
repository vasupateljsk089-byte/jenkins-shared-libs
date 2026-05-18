def call(String imageName, String imageTag, String credentailId)
{
     withCredentials([usernamePassword(
        credentialsId: "${credentailId}",
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh """
        docker login -u ${dockerHubUser} -p ${dockerHubPass}
        docker push ${dockerHubUser}/${imageName}:${imageTag}
        """
    }
}

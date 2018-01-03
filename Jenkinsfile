call()
def call() {
	node {
		stage('Initialization') {
			echo 'here'
			checkout scm
			echo 'branchName---------> ${env.NODE_NAME}'
			echo 'branchName---------> ${this.env}'
			echo 'MicroserviceInformation---------> [${getMicroserviceInformation()}]'
		}
		stage('Build') {
			sh 'printenv'
		}
	}
}
private String getMicroserviceInformation() {
    def pom = readMavenPom file: 'pom.xml'
    
    String artifactId = pom.artifactId
    String groupId = pom.groupId
    String version = pom.version    
    return artifactId+":"+groupId+":"+version
}

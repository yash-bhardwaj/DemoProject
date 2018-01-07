call()
def call() {
	node {
		stage('Initialization') {
			echo 'here'
			checkout scm
			String branchName = env.BRANCH_NAME
			echo branchName
			echo '${branchName}'
			echo 'branchName---------> ${env.NODE_NAME}'
			def maven = tool 'apache-maven-3.0.1' 
			env.PATH = "${maven}/bin:${env.PATH}"
			echo 'branchName---------> ${env.PATH}'
			String mi = getMicroserviceInformation()
			println mi
			echo 'MicroserviceInformation---------> [${mi}]'
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

node {
    stage('Initialization') {
        checkout scm
        echo 'this--------->'+this
        String branchName = env.NODE_NAME
        echo 'branchName--------->'+branchName
        def mvnHome = tool 'M3'
        echo 'mvnHome--------->'+mvnHome
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        echo 'env.PATH----->['+ env.PATH +']'
        String mi = getMicroserviceInformation()
        echo 'MicroserviceInformation---------> '+mi
    }
    stage('Build') {
        sh 'printenv'
    }
}
private String getMicroserviceInformation() {
    def pom = readMavenPom file: 'pom.xml'
    
    String artifactId = pom.artifactId
    String groupId = pom.groupId
    String version = pom.version    
    return artifactId+":"+groupId+":"+version
}

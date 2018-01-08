node {
    stage('Initialization') {
        checkout scm
        def mvnHome
        echo 'here'
        echo env.NODE_NAME
        echo '5.--------->'
        mvnHome = tool 'M3'
        echo mvnHome
        env.PATH = "${maven}/bin:${env.PATH}"
        echo '7.--------->'
        echo 'branchName---------> ${env.PATH}'
        echo '8.--------->'
        String mi = getMicroserviceInformation()
        echo '9.--------->'
        println mi
        echo '10.--------->'
        echo 'MicroserviceInformation---------> [${mi}]'
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

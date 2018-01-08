node {
    stage('Initialization') {
        checkout scm
        def mvnHome
        echo 'here'
        echo env.NODE_NAME
        echo '5.--------->'
        mvnHome = tool 'M3'
        echo '5.1--------->'
        echo mvnHome
        echo '6.--------->'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        echo '7.--------->'
        echo 'branchName---------> ${env.PATH}'
        echo '8.--------->'
        String mi = getMicroserviceInformation()
        echo mi
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

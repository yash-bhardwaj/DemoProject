node {
    stage('Initialization') {
        checkout scm
        echo 'this.env.BRANCH_NAME--------->'+this.env.NODE_NAME
        String branchName = env.NODE_NAME
        echo 'branchName--------->'+branchName
    }
    stage('Maven') {
        def MAVEN_HOME = tool 'M3'
        MAVEN_HOME = "${MAVEN_HOME}/bin"
        echo 'MAVEN_HOME--------->'+MAVEN_HOME
        env.PATH = "${MAVEN_HOME}/bin:${env.PATH}"
        echo 'env.PATH----->['+ env.PATH +']'
        
        String mi = getMicroserviceInformation()
        echo 'MicroserviceInformation---------> '+mi
        
        try {
            runMavenVerify(MAVEN_HOME)
        } catch(Exception e) {
            echo 'Problem while building job:['+e.getMessage()+']'
        }
        echo 'Ending the script...'
    }
}

private String getMicroserviceInformation() {
    def pom = readMavenPom file: 'pom.xml'
    
    String artifactId = pom.artifactId
    String groupId = pom.groupId
    String version = pom.version    
    return artifactId+":"+groupId+":"+version
}

private String runMavenVerify(MAVEN_HOME) {
    sh "ls -lrth ${MAVEN_HOME}"
    String chmodStatus = sh script: "chmod +x ${MAVEN_HOME}", returnStatus: true
    echo chmodStatus
    int verificationStatus = sh script: "${MAVEN_HOME}/mvn clean verify --fail-at-end --batch-mode --update-snapshots", returnStatus: true
    echo 'Verification Status:['+verificationStatus+']'
    
    if (verificationStatus != 0) {
        error('The Maven verification of the service has failed.')
    }
    else {
        echo 'Maven Stage Passed.'
    }
}


//Gatling Simulation script

def performanceTesting(String htmlOutputLocation) {
    node {
        stage("Performance") {
            gatlingArchive()
            manager.addShortText(htmlOutputLocation)
        }
    }
}

// /mnt/mesos/sandbox/workspace/DemoProject/gatling-test/src/test/results/simulations-1505816818577/index.html
def htmlOutputLocation = "/home/yash/.jenkins/workspace/demo-Pipeline/gatling-test/src/test/results/"


performanceTesting (htmlOutputLocation)


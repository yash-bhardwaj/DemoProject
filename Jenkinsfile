node {
	stage('Initialization') {
		echo 'here'
		checkout scm
		echo 'branchName---------> ${this}'
		echo 'branchName---------> ${this.env}'
		echo 'branchName---------> ${this.env.BRANCH_NAME}'
	}
	stage('Build') {
		steps {
			sh 'printenv'
		}
	}
}

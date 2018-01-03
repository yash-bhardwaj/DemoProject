call()
def call() {
	node {
		stage('Initialization') {
			echo 'here'
			checkout scm
			echo 'branchName---------> ${env.NODE_NAME}'
			echo 'branchName---------> ${this.env}'
			echo 'branchName---------> ${this.env.BRANCH_NAME}'
		}
		stage('Build') {
			sh 'printenv'
		}
	}
}

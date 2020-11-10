node {
    stage('Checkout') {
      echo "Checkout code in progress...."
      checkout scm
    }


    stage('Build') {
    echo "Building in progress...."
    def mavenHome = tool name: 'LocalMaven'
	if(isUnix()){
	  sh "${mavenHome}/bin/mvn clean install"
	}
    }

     stage('Create image') {
	     def newApp
	     def registry = 'registry.hub.docker.com'
	     def registryCredential = 'swe645group'
	     def buildHome = 'swe645group/swe645_restapi'
		docker.withRegistry( 'https://' + registry, registryCredential ) {
			    def buildName = buildHome + ":$BUILD_NUMBER"
				newApp = docker.build buildName
				newApp.push()				
    	}
    }

    stage('Deploy') {
         withKubeConfig([credentialsId: 'rancher-login', serverUrl: 'https://ec2-3-236-123-218.compute-1.amazonaws.com/k8s/clusters/c-phrz2']) {
         sh "sed -i 's/{buildNumber}/$BUILD_NUMBER/g' swe645-restbackend.yaml"
         sh '/usr/local/bin/kubectl apply -f swe645-restbackend.yaml'
        }
        }
}

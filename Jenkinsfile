pipeline {
 agent { label 'new-jenkins' }
 options { skipDefaultCheckout() }	
 stages {
  stage("Checkout SCM") {
   steps {
    cleanWs()
	echo 'checkout scm'
	checkout scm
   }
  }
		
  stage("Unit Test") {
   steps {
	cleanWs()
	checkout scm
	echo 'Unit Test Stage'
	sh 'mvn test'
	//junit 'target\\surefire-reports\\*.xml'	
   }
  }
   
  stage("build package")
  {
   steps {
    sh "mvn clean package"
   }
  }
 }
}  

pipeline {
 agent any
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
   
  stage("Deploy in same server")
  {
   steps {
    sh "java -jar target/spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar --server.port=8083"
   }
  }
 }
}  

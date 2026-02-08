pipeline {
    agent any

    tools {
        maven 'maven3'   // use the Maven configured in Jenkins
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Thammalivaralakshmi/Java-SpringWebExample.git'
            }
        }

        stage('Build WAR with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sh '''
                TOMCAT_HOME=/opt/tomcat
                WAR_NAME=SpringWebExample-0.0.1-SNAPSHOT.war

                echo "Stopping old deployment if exists"
                rm -rf $TOMCAT_HOME/webapps/SpringWebExample-0.0.1-SNAPSHOT*

                echo "Copying WAR to Tomcat"
                cp target/$WAR_NAME $TOMCAT_HOME/webapps/

                echo "Deployment completed"
                '''
            }
        }
    }

    post {
        success {
            echo "✅ Build & Deployment Successful"
        }
        failure {
            echo "❌ Build or Deployment Failed"
        }
    }
}

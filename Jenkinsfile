pipeline{
   agent any
   tools{
      maven 'maven'
      jdk 'JDK11'
   }
  stages {
      stage('Maven Build'){
          steps{
             dir('C:/WINDOWS/system32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/SpringAWSIntegration'){
                   sh 'mvn -B -DskipTests clean package'
                }
          }
      }
      stage('Maven Test'){
            steps{
               dir('C:/WINDOWS/system32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/SpringAWSIntegration'){
                   sh 'mvn test'
                }
            }
            post{
            always{
                junit 'target/surefire-reports/*.xml'
            }
        }
        }
  }
}

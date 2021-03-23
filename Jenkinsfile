pipeline{
   agent any
   tools{
      maven 'maven'
      jdk 'JDK11'
   }
  stages {
      stage('Maven Build'){
          steps{
                   sh 'mvn -B -DskipTests clean package'
          }
      }
  }
}

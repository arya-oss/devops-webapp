node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git url: 'https://github.com/rajmani1995/devops-webapp.git'
      mvnHome = tool 'M3'
   }

   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean package -DskipTests"
      } else {
         bat(/"${mvnHome}\bin\mvn" -DskipTests clean package/)
      }
   }
   
   stage('Unit Test') {
       if (isUnix()) {
           sh "'${mvnHome}/bin/mvn' test"
       } else {
           bat(/"${mvnHome}\bin\mvn" test/)
       }
   }
   
   stage('Integration Test') {
       if (isUnix()) {
           sh "cp /opt/properties/webapp.properties src/main/resources"
           sh "'${mvnHome}/bin/mvn' clean integration-test -Dsurfire.skip=true"
       } else {
           bat(/"${mvnHome}\bin\mvn" clean integration-test -Dsurfire.skip=true/)
       }
   }
   
   stage('Deploy') {
       if (isUnix()) {
            sh "rm -rf /opt/tomcat/webapps/WebApp"
            sh "cp target/WebApp.war /opt/tomcat/webapps/"
            sh "/opt/tomcat/bin/catalina.sh stop"
            sh "sleep 10s"
            sh "/opt/tomcat/bin/catalina.sh start"
       }
   }
}

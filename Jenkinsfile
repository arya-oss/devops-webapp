node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
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
}

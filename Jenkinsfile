node {
    try {
        stage('Checkout') {
                git branch: 'main', url: 'https://github.com/mbarghuthi/Apex.git'
        }
        stage('Clean') {
            bat 'mvn clean'
        }
       stage('Test') {
            bat 'mvn test -DreportDirectory="%WORKSPACE%\\reports"'
       }
    } finally {
        stage('Archive Reports') {
             archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
             archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
             archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true
             junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }
        stage('Publish HTML Report') {
            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                 reportFiles: '**/*.html',
                 reportName: 'Extent Report',
                  reportTitles: 'Apex Automation Extent Report'
           ])
       }
   }
}
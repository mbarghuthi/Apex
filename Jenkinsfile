node {
    stage('Checkout') {
        git branch: 'main', url: 'https://github.com/mbarghuthi/Apex.git'
    }

    stage('Clean') {
        bat 'mvn clean'
    }

    stage('Test') {
        bat 'mvn test -DreportDirectory="%WORKSPACE%\\reports"'
    }

    stage('Archive Reports') {
        archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
        archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
        archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true
        junit 'target/surefire-reports/*.xml'
    }

    stage('Publish HTML Report') {
        publishHTML(target: [
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: '**/Apex-Automation-Report.html',
            reportName: 'Extent Report',
            reportTitles: 'Apex Automation Extent Report'
        ])
    }
}
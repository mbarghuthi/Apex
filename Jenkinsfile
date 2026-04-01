node {
    def testExitCode = 0

    try {
        stage('Checkout') {
            git branch: 'main', url: 'https://github.com/mbarghuthi/Apex.git'
        }

        stage('Clean') {
            sh 'mvn clean'
        }

        stage('Test') {
            testExitCode = sh(
                script: 'mvn test -DreportDirectory="$WORKSPACE/reports"',
                returnStatus: true
            )

            if (testExitCode != 0) {
                echo "Tests failed, but pipeline will continue."
            }
        }
    } finally {
        stage('Archive Reports') {
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true

            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true,
                skipPublishingChecks: true,
                skipMarkingBuildUnstable: true
            )
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
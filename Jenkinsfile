pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK8'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mbarghuthi/Apex.git'
            }
        }

        stage('Clean') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean'
                    } else {
                        bat 'mvn clean'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test -DreportDirectory="%WORKSPACE%\\reports"'
            }
        }
    }

   post {
       always {
           echo 'Build finished'

           // Create latest folder
           bat '''
           if exist reports\\latest rmdir /s /q reports\\latest
           mkdir reports\\latest

           set "LATEST_DIR="
           for /f "delims=" %%D in ('dir /ad /b /o-d reports') do (
               if /i not "%%D"=="latest" (
                   set "LATEST_DIR=%%D"
                   goto :copy
               )
           )

           :copy
           if defined LATEST_DIR (
               xcopy "reports\\%LATEST_DIR%\\*" "reports\\latest\\" /E /I /Y
           )
           '''

           archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
           archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
           archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true

           junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

           // 🔥 THIS IS THE KEY CHANGE
           publishHTML(target: [
               allowMissing: true,
               alwaysLinkToLastBuild: true,
               keepAll: false,
               reportDir: 'reports/latest',
               reportFiles: 'Apex-Automation-Report.html',
               reportName: 'Extent Report',
               reportTitles: 'Apex Automation Extent Report'
           ])
       }
   }

        success {
            echo 'Build SUCCESS'
        }

        failure {
            echo 'Build FAILED'
        }
    }
}
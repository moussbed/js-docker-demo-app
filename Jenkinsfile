pipeline {
    agent any

    stages {

        stage("build") {

            steps {
                echo 'Building the application ...'
                script {
                    def test = 2 + 2 > 4 ? 'cool' : 'not cool'
                    println test
                }
                nodejs('Node-10.17'){
                   sh 'yarn install'
                }
            }
        }

        stage("test") {
            
            steps {
                echo 'Testing the application ...'
               
            }
        }

        stage("deploy") {

             when {
                expression{
                    BRANCH_NAME == 'main'
                }
            }
            // This steps will run if if the branch is 'dev'

            steps {
                echo 'Deploying the application ...'
               
            }
        }

    }
    // Execute some logic after all stages executed
    post {
        always {
           sh 'Always executed after all stages executed'
        }
        success {
           sh 'Executed except if all stages are completed'
        }
        failure {
           sh 'Executed unless an error triggered'
        }
    }

}
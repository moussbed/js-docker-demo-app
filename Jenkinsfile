// All environment varaibles of Jenkins come from this link http://localhost:8081/env-vars.html/
// If you want to define your own environment variable 
// you have to explicitly add environment section in the pipeline.
// All variable define inside the environment section are available everywhere
pipeline {
    agent any

    environment{
       NEW_VERSION = '1.3.0'
       SERVER_CREDENTIALS = credentials('server-credentials')
    }

    stages {

        stage("build") {

            steps {
                echo 'Building the application ...'
                echo "Building version ${NEW_VERSION} ..."

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
                echo "Deploying with ${SERVER_CREDENTIALS}"

                // We can get credentials where we need them whithout declaring them in the environment section
                withCredentials([ usernamePassword(credentials : 'server-credentials', usernameVariable: USER, passwordVariable: PWD) ]){
                        
                       // sh "some script ${USER} ${PASSWORD}"
                }
               
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

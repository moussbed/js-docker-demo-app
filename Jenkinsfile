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

            steps {
                echo 'Deploying the application ...'
               
            }
        }

    }

}
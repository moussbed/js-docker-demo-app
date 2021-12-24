def buildApp(){
    echo 'Building application ...'
    echo "Building version ${NEW_VERSION} ..."
}

def testApp(){
   echo 'Testing the application ...'
}

def deployApp(){
    echo 'Deploying the application ...'
    echo "Deploying version  ${params.VERSION}"
    echo "Deploying with ${SERVER_CREDENTIALS}"
}

return this
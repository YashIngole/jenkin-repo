pipeline {
agent any 
environment {
    prod_server_ip = "192.168.9.0"
    uat_server_ip = "192.168.6.2"
}
stages {
    stage("printing default variables ")
    {
        steps {
            sh 'printenv'
        }
    }
    stage('printing custom variables')
    {
        steps{
            echo "HUDSON URL IS $HUDSON_URL"
            echo "build id is $BUILD_ID"
            echo "print workspace $WORKSPACE"
        }
    }
    stage('printing local variable')
    {
        steps{
            echo "prod server ip is $prod_server_ip"
            echo " uat server ip is $uat_server_ip"
        }
    }
    stage("step variable ")
    { 
        environment{
        var1 = "demo1"
        var2 = "demo2"
        
    }
    steps {
        echo "value of variable $var1"
        echo "value of variable $var2"
    }

    }
}
}
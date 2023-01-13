pipeline {
    agent {
        label 'slave'
    }
    stages {
        stage("install http") {
            steps{
    echo "configuring http" 
    sh 'sudo yum update'            
    sh 'sudo yum install httpd -y'
    sh 'sudo systemctl start httpd'
    sh 'sudo systemctl enable httpd'
            }
        }
    
    stage("configure css") {
        steps {

        sh 'sudo yum install wget -y'
        
        sh 'sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page287/onix-digital.zip'
        sh 'unzip -o onix-digital.zip'
         }
          }
    stage("extract the css template"){
steps {
   
        sh 'sudo cp -R templatemo_565_onix_digital/index.html /var/www/html/'
}
    }
    stage("curl")
     {
        steps {
        sh 'curl 18.234.215.130'
        }
    }
}
}

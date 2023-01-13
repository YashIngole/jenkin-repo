pipeline {
    agent any
    stages {
        stage("install http") {
            steps{
sh 'sudo yum update'            
sh 'sudo yum install httpd -y'
sh 'sudo systemctl start httpd'
sh 'sudo systemctl enable httpd'
            }
        }
    }
    stage("configure css") {
        steps {

        sh 'sudo yum install wget -y'
        sh 'sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page287/onix-digital.zip'
         }
          }
    stage("extract the css template"){
steps {
        sh 'unzip onix-digital.zip'
        sh 'sudo -s'
        rm '/root/var/www/html/index.html'
        sh 'cp -R templatemo_565_onix_digital/index.html /root/var/www/html/index.html '
}
    }
    stage("curl")
     {
        steps {
        sh 'curl 18.234.215.130'
        }
    }
}
pipeline {
   agent any 

   stages {
    stage ("install httpd"){
steps {
        echo "configuring httpd"
        sh "sudo -S yum update -y"
        sh "sudo yum install httpd -y"
        sh "sudo systemctl enable httpd"
        sh "sudo systemctl start httpd"
}
    }
    stage ("configure css") {
        steps {
            echo "downloading free css template"

            sh "sudo yum install wget -y"
            sh "sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page287/beautiflie.zip"
            sh "unzip -o beautiflie.zip"
        }
    }
        stage ("host index.html")
{
        steps {
            sh "sudo cp -R html/index.html /var/www/html/"
            sh "curl 3.80.132.166"
        }

    }

   }

}

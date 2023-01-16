pipeline {
    agent {
        label 'slave'
    }

    stages {
        stage('Getting the project from GIT') {
            steps {
               echo 'Pulling code';
                git branch: 'master',
                url: 'https://github.com/YashIngole/onlinebookstore.git';
            }
        }
        
    stage('Cleaning and artificact construction') {
             
            steps {
                echo 'making package'
                sh 'mvn clean package'
                sh 'ls -lart'
            }
        }
        stage("AWS Cli installation")
{
    steps {
        echo "Installing AWS CLI"
        sh 'sudo yum install awscli'
        sh 'aws --version'
    }
}
stage("Push War file to S3 bucket")
{
    steps {
       withAWS(credentials: 'yash-aws-creds', region: 'us-east-1')
        {
        sh "aws s3 ls"
        sh "aws s3 mv /home/ec2-user/workspace/tomcatS3/target/onlinebookstore.war s3://rajudhep/war-files/"
        }
    }
}
stage("Tomcat configuration")
{
    steps {
        echo "installing tomcat"
        sh 'sudo yum install wget -y'
        sh 'wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.84/bin/apache-tomcat-8.5.84.tar.gz'
        sh 'tar -zvxf apache-tomcat-8.5.84.tar.gz'
        sh 'cd /home/ec2-user/workspace/tomcatS3/apache-tomcat-8.5.84/bin'
        sh './startup'

    }
}
    }


}



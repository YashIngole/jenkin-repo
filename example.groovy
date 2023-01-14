pipeline {
agent any 

environment {
    a = "26" //int a = 26
}
stages {

    stage ('direcotry dakhav') {
        steps {
            sh 'pwd'
        }
    }
    stage ('file banav') {

        steps {
            sh 'touch abc'
            sh 'mkdir kkc'
        }
        }
        stage ('calling a'){ 
        steps {
            echo "$a"
        }

        }
}


}

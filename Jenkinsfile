pipeline{
    agent none
    stages{

        stage('Build'){
            agent{
                docker{
                    image 'maven:3-alpine'
                    // label 'Agent01'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps{
               sh 'mvn clean install'
              // stash includes: '**/*.war',name: 'app'
          }
        }
         stage('deploy'){
            agent any
            steps{
                //unstash 'app'
                sh 'docker ps -f name=helloapp -q | xargs --no-run-if-empty docker container stop'
                sh 'docker container ls -a -fname=helloapp -q | xargs -r docker container rm'
                sh 'docker build -t helloapp .'
                sh 'docker run -itd -p 8082:8080 --name helloapp helloapp:latest'
            }
        }
    }
    
            post{
            failure{
                echo 'Job failure'
               
            }
        }

}

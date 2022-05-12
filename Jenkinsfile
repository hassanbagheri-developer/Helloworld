pipeline{
    agent none
    stages{
        // stage('Git'){
        //     agent any
        //     steps{
        //       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs:
        //       [[url: 'https://github.com/hassanbagheri-developer/Helloworld.git']]])
        //   }
        // }

        stage('Build'){
            agent{
                docker{
                    image 'maven:3-alpine'
                    // label 'my_slave01'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps{
               sh 'ls'
               sh 'ls /root/.m2'
               sh 'mvn clean install'
               stash includes: '**/*.war',name: 'app'
          }
        }
         stage('deploy'){
            agent any
            /* agent{
                // label 'my_slave01'
            }*/
            steps{
                unstash 'app'
                sh 'docker ps -f name=helloapp -q | xargs --no-run-if-empty docker container stop'
                sh 'docker container ls -a -fname=helloapp -q | xargs -r docker container rm'
                sh 'docker build -t helloapp .'
                sh 'docker run -itd -p 8082:8080 --name helloapp helloapp:latest'
                
                
                sh 'ip a'
                sh 'docker images'
            }
        }
    }
    
            post{
            failure{
                echo 'Job failure'
               
            }
        }

}

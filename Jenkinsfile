timestamps {

 node () {

  stage ('checkout repository') {
   checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub_User', url: 'https://github.com/oktacon95/springbackend']]]) 
  }
  stage ('build docker image') {
   sh "docker build -t springbackend ." 
  }
  stage ('stop old docker image') {
   sh "docker stop springbackend" 
  }
  stage ('create new docker container') {
   sh 'docker run --rm -d --name springbackend -p 8085:8085 -v /var/log/testlogs:/var/log/testlogs springbackend'
  }
 }
}

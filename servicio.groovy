def job = pipelineJob('test') {

    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }

    parameters {
     stringParam('perfil_fuse', 'q9-servicio-test', 'Favor ingresar perfil')
     booleanParam('cargarproperties',false, 'indicar si desea cargar archivo de propiedades.')
     choiceParam('SERVER_DEPLOY', ['10.10.10.10', '20.20.20.20'])
     }

    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job demo jenkins onprem"
def hostsIPsMap = [
  'QA1': '10.10.10.10',
  'QA2': '20.20.20.20'



]


def SERVER_DEPLOY=null 
SERVER_DEPLOY = hostsIPsMap[]




pipeline { 
    agent any 
    

    stages {
        stage('Build') { 
            steps { 
                echo 'holahola' 
            }
        }
        stage('Deploy') {
            steps {

              script{
              print "SERVER_DEPLOY: " + SERVER_DEPLOY
               if ("${SERVER_DEPLOY}" == '10.10.10.10') {
                 sh '''
                 ls
                 '''
               } else {
                 sh '''
                 ls -l
                 '''
                  }
               }
            }
        }
    }
}
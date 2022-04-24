def job = pipelineJob('test') {
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
def hostsIPsMap = [
  'QA1': '10.10.10.10',
  'Q2': '20.20.20.20'

]

def SERVER_DEPLOY=null 
SERVER_DEPLOY = hostsIPsMap[DESTINO]
    
    parameters {
    stringParam('perfil_fuse', 'q9-servicio-test', 'Favor ingresar perfil')
    booleanParam('cargarproperties',false, 'indicar si desea cargar archivo de propiedades.')
    stringParam ('DEPLOY_SERVER')

    }
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
}

def jobDescription = "job demo jenkins onprem"

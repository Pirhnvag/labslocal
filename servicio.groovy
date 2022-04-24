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
     choiceParam("$SERVER_DEPLOY", ['10.10.10.10', '20.20.20.20', 'option 3'])
     }
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job demo jenkins onprem"

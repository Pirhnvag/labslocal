def job = pipelineJob('service_poc') {
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
    parameters {
    stringParam('perfil_fuse', 'q5a-servicio-poc', 'Favor ingresar perfil')
    booleanParam('cargarproperties',false, 'Indicar si desea cargar archivo de propiedades.')
    choiceParam('SERVER_DEPLOY', ['10.10.10.10', '20.20.20.20', '30.30.30.30'])
    }
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job poc"

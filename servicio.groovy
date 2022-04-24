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
    [$class: 'ExtendedChoiceParameterValue', name: 'param_name', value: 'param_value']
    }
    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job demo jenkins onprem"

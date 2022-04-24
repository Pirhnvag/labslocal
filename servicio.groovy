build job:'NameOfTheJob', parameters: [
      string(name: 'FirstOption', value: "test"),
      string(name: 'AnotherOption', value: "test12")
]
//def job = pipelineJob('test') {

    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }

    parameters {
     stringParam('perfil_fuse', 'q9-servicio-test', 'Favor ingresar perfil')
     booleanParam('cargarproperties',false, 'indicar si desea cargar archivo de propiedades.')
    }

    definition {
        cps {
            script(readFileFromWorkspace('test.jenkinsfile'))
            sandbox()
        }
    }

def jobDescription = "job demo jenkins onprem"

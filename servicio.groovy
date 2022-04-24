def job = pipelineJob('Prod/servicio') {
    definition {
        cps {
            script(readFileFromWorkspace('src/main/groovy/projects/Prod/servicio.jenkinsfile'))
            sandbox()
        }
    }
    parameters {
    stringParam('perfil_fuse', 'prod-servicio', 'Favor ingresar perfil')
    booleanParam('cargarproperties',false, 'indicar si desea cargar archivo de propiedades.')

    }
    definition {
        cps {
            script(readFileFromWorkspace('src/main/groovy/projects/Prod/servicio.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job demo jenkins onprem"

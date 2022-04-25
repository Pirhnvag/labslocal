def job = pipelineJob('test') {

    definition {
      cps {
        script(readFileFromWorkspace('test.jenkinsfile'))
        sandbox()
          }
     }
    scm {
      git {
        remote {
          url 'git@https://github.com/Pirhnvag/labslocal.git'
     } 
    parameters {
      stringParam('perfil_fuse', 'q9-servicio-test', 'Favor ingresar perfil')
      booleanParam('cargarproperties',false, 'Indicar si desea cargar archivo de propiedades.')
      choiceParam('seleccioneAmbiente', ['QA1', 'QA2', 'QA3', 'QA4', 'QA5', 'QA6', 'QA7', 'QA8', 'QA9'])
     }
    parameters {
      gitParam('Branch') {
      description 'La rama de Git a seleccionar'
      type 'BRANCH'
      defaultValue 'TESTING'
               }
     }
    definition {
      cps {
        script(readFileFromWorkspace('test.jenkinsfile'))
        sandbox()
            }
         }
     }
def jobDescription = "job demo jenkins poc"
    }
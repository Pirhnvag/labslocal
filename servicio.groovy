def job = pipelineJob('test') {

    definition {
      cps {
        script(readFileFromWorkspace('test.jenkinsfile'))
        sandbox()
          }
     }
    parameters {
      stringParam('perfil_fuse', 'q9-servicio-test', 'Favor ingresar perfil')
      booleanParam('cargarproperties',false, 'Indicar si desea cargar archivo de propiedades.')
      choiceParam('seleccionar_ambiente', ['QA1', 'QA2', 'QA3', 'QA4', 'QA5', 'QA6', 'QA7', 'QA8', 'QA9'])
     }
    parameters {
      gitParam('branch') {
      description 'La rama de Git a seleccionar'
      type 'BRANCH'
      defaultValue 'testing'
               }
     }
    //definition {
      //cps {
        //script(readFileFromWorkspace('test.jenkinsfile'))
        //sandbox()
          //}
        //}
     }
def jobDescription = "job demo jenkins poc"

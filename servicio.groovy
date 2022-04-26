def job = pipelineJob('job-poc') {

    definition {
      cps {
        script(readFileFromWorkspace('test.jenkinsfile'))
        sandbox()
          }
     }
    parameters {
      stringParam('perfil_fuse', 'ingresarambiente-proceso-seguro-venta', 'Favor ingresar perfil')
      booleanParam('cargarproperties',false, 'Indicar si desea cargar archivo de propiedades.')
      choiceParam('Ambiente', ['QA1', 'QA2', 'QA3', 'QA4', 'QA5', 'QA6', 'QA7', 'QA8', 'QA9'])
     }
    parameters {
      gitParam('Branch') {
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

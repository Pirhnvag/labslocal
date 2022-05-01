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
    parameters {
        activeChoiceParam('seleccione_ambiente') {
            description('Favor seleccione ambiente')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["Q5", "Q7"]')
                fallbackScript('"fallback choice"')
            }
        }
    }
     parameters {
        activeChoiceReactiveParam('seleccione_servidor') {
            description('Favor seleccione servidor')
            filterable()
            choiceType('RADIO')
            groovyScript {
                script('if ( seleccione_ambiente == "Q5") { return ["10.21.61.182", "10.21.61.183", "10.21.61.184"] } else if ( seleccione_ambiente == "Q7") { return ["10.20.73.20", "10.20.73.21", "10.20.73.22"] } else if (states == "Punjab") { return ["Ludhiana", "Amritsar", "Jalandhar"] }')
                fallbackScript('"fallback choice"')
            }
            referencedParameter('seleccione_ambiente')
            //referencedParameter('BOOLEAN-PARAM-2')
        }
    }
    authorization {
        permission('hudson.model.Item.Build', 'q7-profile')
    }
}
def jobDescription = "job demo jenkins poc"

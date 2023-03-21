pipelineJob('job-poc') {
  definition {
    cps {
      script(readFileFromWorkspace('test.jenkinsfile'))
      sandbox()
    }
  }
   parameters {
                activeChoiceParam('DESTINO') {
                  choiceType('SINGLE_SELECT')
                  groovyScript {
                    script('["seleccione:selected", "q5a", "q7a"]')
                    fallbackScript('return ["ERROR"]')
                description('Selecciona el Destino del proyecto. (Campo obligatorio)')
                }
            }
        }
  parameters {
    stringParam('perfil_fuse', '', 'Favor ingresar perfil')
    //choiceParam('perfil_fuse', ['q5a-persona-datos'], 'Perfil por defecto del servicio.')
    booleanParam('cargarproperties', false, 'Indicar si desea cargar archivo de propiedades.')
  }
  parameters {
    gitParam('branch') {
    description 'Favor seleccione branch'
    type 'BRANCH'
    defaultValue 'testing'
    }
  }
  definition {
    cps {
      script(readFileFromWorkspace('test.jenkinsfile'))
      sandbox()
    }
  }
  //parameters {
    //activeChoiceReactiveParam('seleccione_servidor') {
      //description('Favor seleccione servidor')
      //filterable()
      //choiceType('RADIO')
      //groovyScript {
        //script('if ( seleccione_ambiente == "Q5A") { return ["10.21.61.182", "10.21.61.183", "10.21.61.184"] } else if ( seleccione_ambiente == "Q7") { return ["10.20.73.20", "10.20.73.21", "10.20.73.22"] } ')
        //fallbackScript('"fallback choice"')
      //}
      //referencedParameter('seleccione_ambiente')
    //referencedParameter('BOOLEAN-PARAM-2')
    //}
  //}
  //authorization {
    //permission('hudson.model.Item.Build', 'q7-profile')
  //}
}


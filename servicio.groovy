pipelineJob('job-poc') {
  definition {
    cps {
      script(readFileFromWorkspace('test.jenkinsfile'))
      sandbox()
    }
  }
    parameters {
      stringParam('perfil_fuse', 'ingresarambiente-proceso-seguro-venta', 'Favor ingresar perfil')
      booleanParam('cargarproperties', false, 'Indicar si desea cargar archivo de propiedades.')
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
        choiceType('RADIO')
        groovyScript {
          script('["Q5", "Q8"]')
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
        script('if ( seleccione_ambiente == "Q5") { return ["10.21.61.182", "10.21.61.183", "10.21.61.184"] } else if ( seleccione_ambiente == "Q8") { return ["10.20.73.20", "10.20.73.21", "10.20.73.22"] } else if (states == "Punjab") { return ["Ludhiana", "Amritsar", "Jalandhar"] }')
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


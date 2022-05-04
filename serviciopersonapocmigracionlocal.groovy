def job = pipelineJob('serviciopersonapocmigracionlocal') {

    parameters {
       stringParam('perfil_fuse', 'q5-persona-datos', 'Favor ingresar perfil')
       booleanParam('cargarproperties',false, 'Indicar si desea cargar archivo de propiedades.')

	}
    definition {
        cps {
            script(readFileFromWorkspace('src/main/groovy/projects/QA/serviciopersonapocmigracionlocal.jenkinsfile'))
            sandbox()
        }
    }
}
def jobDescription = "job demo jenkins onprem"
//helpers.Build_Job_Helper.addGitParameter_branch_testing(job,'PT_BRANCH','DESCENDING_SMART','.*','branch')
//helpers.Build_Job_Helper.general_config_qa(job, jobDescription)
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
          script('["Q5A", "Q7"]')
          fallbackScript('"fallback choice"')
      }
    }
  }
    authorization {
      permission('hudson.model.Item.Build', 'projel')
  }
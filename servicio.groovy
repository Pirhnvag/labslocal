//package com.michelin.cio.hudson.plugins.rolestrategy
//package src.main.java.com.hudson
import hudson.model.User
import hudson.model.Hudson
import hudson.security.AuthorizationStrategy
import hudson.security.Permission
import com.michelin.cio.hudson.plugins.rolestrategy.RoleBasedAuthorizationStrategy
import com.michelin.cio.hudson.plugins.rolestrategy.RoleMap

AuthorizationStrategy strategy = Hudson.getInstance().getAuthorizationStrategy();

jobs = []
user = User.current()
userId = user.getId()

if (strategy != null && strategy instanceof com.michelin.cio.hudson.plugins.rolestrategy.RoleBasedAuthorizationStrategy) {
    roleStrategy = (RoleBasedAuthorizationStrategy) strategy;
    // not very straightforward to get the groups for a given user
    roles = roleStrategy.getGrantedRoles("globalRoles")
    for (entry in roles) {
        role = entry.key
        users = entry.value
        if (role.getName().equals("q5")) {
            if (userId in users) {
                jobs = ["q5"]
                break
            }
        } else if (role.getName().equals("q8")) {
            if (userId in users) {
                jobs = ["q8"]
                break
            }
        }
    }
}
pipelineJob('job-poc') {
  def userIDs = ['q7-profile']

        for (String singer : userIDs) {
            authorization {
                permissions("${singer}", [
                    'hudson.model.Item.Build',
                    'hudson.model.Item.Discover',
                    'hudson.model.Item.Cancel',
                    'hudson.model.Item.Read'
                ])
            }
        }
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


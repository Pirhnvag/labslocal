pipelineJob('job-poc') {
  definition {
    cps {
      script(readFileFromWorkspace('test.jenkinsfile'))
      sandbox()
    }
  }
}

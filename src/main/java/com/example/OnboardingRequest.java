package com.example;

import java.text.ParseException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class OnboardingRequest {

	public static void main(String[] args) {
		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
			      .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
			      .setJdbcUsername("sa")
			      .setJdbcPassword("")
			      .setJdbcDriver("org.h2.Driver")
			      .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
			    ProcessEngine processEngine = cfg.buildProcessEngine();
			    String pName = processEngine.getName();
			    String ver = ProcessEngine.VERSION;
			    System.out.println("ProcessEngine [" + pName + "] Version: [" + ver + "]");
	
	    RepositoryService repositoryService = processEngine.getRepositoryService();
	    Deployment deployment = repositoryService.createDeployment()
	        .addClasspathResource("onboarding.bpmn20.xml").deploy();
	    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
	        .deploymentId(deployment.getId()).singleResult();
	    System.out.println(
	        "Found process definition [" 
	            + processDefinition.getName() + "] with id [" 
	            + processDefinition.getId() + "]");
	}

}

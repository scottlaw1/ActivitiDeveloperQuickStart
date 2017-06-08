package com.example;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class AutomatedDataDelegate implements JavaDelegate {
	
	public void execute(DelegateExecution execution) throws Exception {
		Date now = new Date();
		execution.setVariable("autoWelcomeTime", now);
		System.out.printf("Faux call to backend for [%s]\n",execution.getVariable("fullName"));
	}
}
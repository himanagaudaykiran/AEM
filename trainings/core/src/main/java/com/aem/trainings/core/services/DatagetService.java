package com.aem.trainings.core.services;

import javax.jcr.RepositoryException;

import org.json.JSONObject;

public interface DatagetService {
	
	 public JSONObject getData() throws RepositoryException;
}

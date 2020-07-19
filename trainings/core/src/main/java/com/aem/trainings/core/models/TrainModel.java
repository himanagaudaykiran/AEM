package com.aem.trainings.core.models;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = { Resource.class,
	    SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TrainModel {
	
	@Inject
	@Via("resource")
	private String text;

	@Inject
	@Via("resource")
	private String count;
	
	@PostConstruct
	  private void init() {
		
	}

	public String getText() {
		return text;
	}

	public String getCount() {
		return count;
	}

}

package com.aem.trainings.core.models;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.slf4j.Logger;
import java.util.Objects;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class,
	    SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TrainModel {
	
	@Inject
	@Via("resource")
	private String text;

	@Inject
	@Via("resource")
	private String count;
	
	@Inject
	private SlingHttpServletRequest request;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	  private void init() {
		log.info("inside active metod");
		String[] suffix = null;
		suffix = Objects.requireNonNull(request.getRequestPathInfo().getSuffix()).split("/");
		if(suffix.length >= 1) {
			for (String str : suffix) { 
				log.info("suffix {}", str);
	        } 
		}
		
	}
	
	public String getText() {
		return text;
	}

	public String getCount() {
		return count;
	}

}

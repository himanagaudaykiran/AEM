package com.aem.trainings.core.models;
import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
@Slf4j
public class LombokModel {
	
	@ValueMapValue
	private String text;

	@ValueMapValue
	private String count;
	
	@PostConstruct
	  private void init() {
		log.info("inside active metod");
		
	}
}

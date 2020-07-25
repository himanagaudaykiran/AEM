package com.aem.trainings.config.interfaces;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Get Data Service Config")
public @interface DataGetServiceConfig {
    
    @AttributeDefinition(name="Get Data Service URL", description="Service end point to get data from third party")
    String getDataServiceURL() default "/services/get/Data";

    }

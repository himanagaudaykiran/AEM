package com.aem.trainings.config.interfaces;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Getv Data Service Config")
public @interface CSVDataGetServiceConfig {
    
    @AttributeDefinition(name="Get csv file path", description="Service end point to get data from csv file path")
    String csvFilePath() default "/services/get/Data";

    }

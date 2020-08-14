package com.aem.trainings.core.servlets;
 
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, immediate = true, property = {
	Constants.SERVICE_DESCRIPTION + "=Resource type  Servlet",
	"sling.servlet.methods=" + HttpConstants.METHOD_GET,
	"sling.servlet.resourceTypes=" + "/services/trainings/getData",
	"sling.servlet.extensions=" + "json" })
public class ResourceTypeServlet extends SlingAllMethodsServlet  {
	
	private static final long serialVersionUID = 1L;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	 protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse slingResponse)
	 throws ServletException, IOException {
		slingResponse.setContentType("text/html");
		try {
		
        log.info("Adaptation DONE in resource servlet");
		} catch (Exception e) {
            log.error("{} Exception! ", new Object[] {e.getMessage(), e});
        }
	} 
	
	
}

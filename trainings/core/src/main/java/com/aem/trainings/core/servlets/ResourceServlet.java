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
import com.aem.trainings.core.models.TrainModel;

@Component(service = Servlet.class, immediate = true, property = {
	Constants.SERVICE_DESCRIPTION + "=Resource type  Servlet",
	"sling.servlet.methods=" + HttpConstants.METHOD_GET,
	"sling.servlet.resourceTypes=" + "/apps/trainings/components/content/listnercomp",
	"sling.servlet.selectors=generator",
	"sling.servlet.extensions=" + "html" })
public class ResourceServlet extends SlingAllMethodsServlet  {
	
	private static final long serialVersionUID = 1L;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	 protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse slingResponse)
	 throws ServletException, IOException {
		slingResponse.setContentType("text/html");
		try {
		TrainModel siteModel = request.adaptTo(TrainModel.class);
        log.info("Adaptation DONE");
		slingResponse.getWriter().write(siteModel.getText());
		} catch (Exception e) {
            log.error("{} Exception! ", new Object[] {e.getMessage(), e});
        }
	} 
	
	
}
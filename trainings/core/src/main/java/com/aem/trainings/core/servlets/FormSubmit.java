package com.aem.trainings.core.servlets;

import java.io.IOException;
import java.io.Serializable;

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
import org.json.JSONObject;
import java.util.UUID;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=formdata Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=/bin/training/mySearchServlet",
		"sling.servlet.extensions=" + "html" })
public class FormSubmit extends SlingAllMethodsServlet implements Serializable {

    private static final long serialVersionUID = 7876963440407573851L;
    private static final Logger log = LoggerFactory.getLogger(FormSubmit.class);
   
    
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,  IOException {
    	log.info("formdata servlet invoked");
    	try
        {
           //Get the submitted form data that is sent from the
                //CQ web page  
            String id = UUID.randomUUID().toString();
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String cat = request.getParameter("cat");
            String state = request.getParameter("state");
            String details = request.getParameter("details");
            String date = request.getParameter("date"); 
            String city = request.getParameter("city"); 
         
            //Encode the submitted form data to JSON
            JSONObject obj=new JSONObject();
            obj.put("id",id);
            obj.put("firstname",firstName);
            obj.put("lastname",lastName);
            obj.put("address",address);
            obj.put("cat",cat);
            obj.put("state",state);
            obj.put("details",details);
            obj.put("date",date);
            obj.put("city",city);
             
               //Get the JSON formatted data    
            String jsonData = obj.toString();
             
               //Return the JSON formatted data
           response.getWriter().write(jsonData);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      }
}

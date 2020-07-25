package com.aem.trainings.core.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;

public class CustomUtils {
	private static final Logger log = LoggerFactory.getLogger(CustomUtils.class);
	private CustomUtils() {
		super();
	}
	
	public static ResourceResolver getServiceUser(ResourceResolverFactory resolverFactory, String subServicename) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(ResourceResolverFactory.SUBSERVICE, subServicename);
		ResourceResolver rs = null;
		try {
			rs = resolverFactory.getServiceResourceResolver(paramMap);
		} catch (LoginException e) {
			log.error("Error while getting service user reference {} ", e.getMessage());
		}
		return rs;
	}
	
	    public static String getCoutnryCode(String resourcePath, ResourceResolver resourceResolver) {
		Resource resource = resourceResolver.getResource(resourcePath);
		if (resource != null) {
		    Page currentPage = resource.adaptTo(Page.class);
		    if (currentPage != null) {
		        Locale locale = currentPage.getLanguage();
		        return locale.getCountry();
		    }
		}
	    return null;
	       
	   }
	    public static String getLanguageCode(String resourcePath, ResourceResolver resourceResolver) {
		Resource resource = resourceResolver.getResource(resourcePath);
		if (resource != null) {
		    Page currentPage = resource.adaptTo(Page.class);
		    if (currentPage != null) {
		        Locale locale = currentPage.getLanguage();
		        return locale.getLanguage();
		    }
		}
	    return null;
	       
	   }
	    
	    public static String getQueryParams(SlingHttpServletRequest request) {
			Map<String, String[]> params = (Map<String, String[]>) request.getParameterMap();
			StringBuilder sb = new StringBuilder("?"); 
			if (!params.isEmpty()) {
				
				for (Map.Entry<String, String[]> entry : params.entrySet()) {
					String key = entry.getKey();
						String value =  params.get(key)[0];
						if (sb.toString().equalsIgnoreCase("?")) {
							sb = sb.append(key + "=" + value);

						} else {
							sb = sb.append( "&" + key + "=" + value);

						}
				}
			}
			log.info("requestParams: {}",sb);
			if(null==sb ||sb.toString().equalsIgnoreCase("?")) {
					return "";
			}
			return sb.toString();
		}
	    
	    public static String getPagePath(SlingHttpServletRequest request, String pagePath) {
	    	String uri = "";
	    	String serverName = request.getServerName();
	    	if(request.getServerPort()>0) {
	    		serverName = serverName +":" + request.getServerPort() ;
	    	}
	    	uri = request.getScheme() + "://" + serverName;
	    	log.info("[getPagePath] Return URL: {}", uri);
	    	return uri;
	    }
	    
	    public static Node getNode(ResourceResolver resourceResolver, String path) throws RepositoryException {
			Node configNodeRoot = null;
			Node configNode = null;
			Resource configResource = resourceResolver.getResource(path);
			if (configResource != null) {
				configNodeRoot = configResource.adaptTo(Node.class);
				if (configNodeRoot != null) {
					configNode = configNodeRoot.getNode("jcr:content");
				}}
			return configNode;
			
		}
		
}

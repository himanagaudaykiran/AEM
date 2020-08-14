package com.aem.trainings.core.services.impl;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.ResourceResolver;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import com.aem.trainings.config.interfaces.DataGetServiceConfig;
import com.aem.trainings.core.services.DatagetService;
import com.aem.trainings.core.utils.CustomUtils;

@Component(service = DatagetService.class, immediate=true)
@Designate(ocd = DataGetServiceConfig.class)
public class DatagetServiceImpl implements DatagetService{

	 private static final Logger LOG = LoggerFactory.getLogger(DatagetService.class);

	    @Reference
	    private ResourceResolverFactory resolverFactory;
	   
	    private DataGetServiceConfig config;
	    
	    @Activate
		protected void activate(DataGetServiceConfig config) {
			this.config = config;
		}

		@Override
		public JSONObject getData() throws RepositoryException {
			JSONObject result = null;
			LOG.info("inside get data service impl {}", config.getDataServiceURL());
			ResourceResolver resourceResolver = CustomUtils.getServiceUser(resolverFactory, "dataReadWriteUser");
			Node node = CustomUtils.getNode(resourceResolver, "/content/trainings");
			node.setProperty("issued_at", "today");
			node.getSession().save();
			String token = node.getProperty("issued_at").getString();
			LOG.info("get node props {}", token);
			return result;
		}
}

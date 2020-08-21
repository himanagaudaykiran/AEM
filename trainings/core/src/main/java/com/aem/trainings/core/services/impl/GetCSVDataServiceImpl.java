package com.aem.trainings.core.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aem.trainings.config.interfaces.CSVDataGetServiceConfig;
import com.aem.trainings.core.beans.CSVDataBean;
import com.aem.trainings.core.services.GetCSVDataService;
import com.aem.trainings.core.utils.CustomUtils;
import com.aem.trainings.core.utils.FileUtils;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
/**
 * Service for county population.
 *
 * @author hima naga uday kiran
 */

@Component(service = GetCSVDataService.class, immediate = true)
@Designate(ocd = CSVDataGetServiceConfig.class)
public class GetCSVDataServiceImpl implements GetCSVDataService {

	private static final Logger LOG = LoggerFactory.getLogger(GetCSVDataServiceImpl.class);
	
	private CSVDataGetServiceConfig config;
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	private List<CSVDataBean> zipList;
	
	@Activate
	public void activate(CSVDataGetServiceConfig config) {
        this.config = config;
        parseCSVFile();
	}
	
	@Override
	public List<CSVDataBean> getCountyByCode(String zipCode) {
			  List<CSVDataBean> countyData = new ArrayList<>();
	          Map<String, List<CSVDataBean>> groupByZipeMap = zipList.stream().collect(Collectors.groupingBy(CSVDataBean::getAddress));
	          if(groupByZipeMap.containsKey(zipCode)) {
	          countyData = groupByZipeMap.get(zipCode);
	          }
		return countyData;
	}
	
	@Override
	public void parseCSVFile() {
		try (ResourceResolver resourceResolver = CustomUtils.getServiceUser(resourceResolverFactory, "datareadwrite")){
			InputStream content = FileUtils.getFileInputStream(config.csvFilePath(), resourceResolver);
			MappingIterator<CSVDataBean> mappingIterator = new CsvMapper().readerWithTypedSchemaFor(CSVDataBean.class).readValues(content);
			zipList = mappingIterator.readAll();
		} catch (IOException e) {
			LOG.error("Exception while parsing csv file {}", e.getLocalizedMessage());
		}
	}
		
	}

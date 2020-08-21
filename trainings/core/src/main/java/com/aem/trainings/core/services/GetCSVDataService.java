package com.aem.trainings.core.services;

import java.util.List;
import com.aem.trainings.core.beans.CSVDataBean;;

public interface GetCSVDataService {
	
	public void parseCSVFile();
	public List<CSVDataBean> getCountyByCode(String zipCode);
}

package com.aem.trainings.core.utils;

import java.io.InputStream;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;

public class FileUtils {

	private FileUtils() {
		super();
	}

	private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

	public static InputStream getFileInputStream(String filePath, ResourceResolver resourceResolver) {
		Resource fileResource = resourceResolver.getResource(filePath);
		if (fileResource != null) {
			LOG.info("fileResource {}", fileResource.getName());
			Asset asset = fileResource.adaptTo(Asset.class);
			Resource original = asset.getOriginal();
			return original.adaptTo(InputStream.class);
		}
		return null;
	}
}


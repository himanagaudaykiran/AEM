package com.aem.trainings.core.beans;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonPropertyOrder({ "cdatetime", "address", "district", "beat", "grid", "crimedescr", "ucr_ncic_code", "latitude",
		"crimedescr" })
public class CSVDataBean {

	@JsonProperty("cdatetime")
	private String cdatetime;

	@JsonProperty("address")
	private String address;

	@JsonProperty("district")
	private String district;

	@JsonProperty("beat")
	private String beat;

	@JsonProperty("grid")
	private String grid;

	@JsonProperty("crimedescr")
	private String crimedescr;

	@JsonProperty("ucr_ncic_code")
	private String ucr_ncic_code;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	public String getCdatetime() {
		return cdatetime;
	}

	public String getAddress() {
		return address;
	}

	public String getDistrict() {
		return district;
	}

	public String getBeat() {
		return beat;
	}

	public String getGrid() {
		return grid;
	}

	public String getCrimedescr() {
		return crimedescr;
	}

	public String getUcr_ncic_code() {
		return ucr_ncic_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

}

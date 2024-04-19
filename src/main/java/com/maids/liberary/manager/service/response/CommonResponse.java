package com.maids.liberary.manager.service.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse {


	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommonResponse(String statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	@JsonProperty(value = "statusCode")
	private String statusCode;

	@JsonProperty(value = "statusDescription")
	private String description;



}

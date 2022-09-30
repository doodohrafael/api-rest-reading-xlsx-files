package com.rafael.readingxlsxfiles.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	INVALID_PARAMETER("/invalid-parameter", "Invalid parameter"),
	BUSINESS_ERROR("/business-error", "Business rule violation"),
	SYSTEM_ERROR("/system-error", "System Error"),
	RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found");
	
	private String uri;
	private String title;
	
	private ProblemType(String path, String title) {
		uri = "https://www.linkedin.com/in/douglas-rafael-867822a0/" + path;
		this.title = title;
	}

}

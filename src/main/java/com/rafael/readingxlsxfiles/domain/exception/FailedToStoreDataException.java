package com.rafael.readingxlsxfiles.domain.exception;

public class FailedToStoreDataException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public FailedToStoreDataException(String message) {
		super(message);
	}

}

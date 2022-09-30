package com.rafael.readingxlsxfiles.domain.exception;


public class CostumerNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public CostumerNotFoundException(String message) {
		super(message);
	}
	
	public CostumerNotFoundException(Long costumerId) {
		super(String.format("There is no customer record with code %d", costumerId));
	}

}

package com.pet.api.exceptions;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 2108734679764340393L;

	public BusinessException(String message) {
        super(message);
    }
}
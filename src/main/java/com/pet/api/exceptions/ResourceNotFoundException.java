package com.pet.api.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2567046108979688273L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.pet.api.exceptions;

public class ClienteNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7419414712871767949L;

		public ClienteNotFoundException(String message) {
	        super(message);
	    }
}

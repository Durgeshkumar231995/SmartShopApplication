package com.lti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786825297836238532L;

	public ItemNotFoundException(String message) {
		super(message);
		
	}
	

}

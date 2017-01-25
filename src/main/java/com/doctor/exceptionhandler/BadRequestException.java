package com.doctor.exceptionhandler;

public class BadRequestException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message , Throwable throwable) {
		super(message,throwable);
	}
}
package com.ihub.exceptionhandler;

public class IhubException extends Exception {
	
	
	private final int errorCode;
	private String message;
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	
	public IhubException(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
	
	
	
	
	
}

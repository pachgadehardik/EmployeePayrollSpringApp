package com.bridgelabz.employeepayrollapp.excpetions;

public class JWTException extends RuntimeException{
	

	private static final long serialVersionUID = 7141438540271496879L;
	
	private int statusCode;
	public JWTException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	
}

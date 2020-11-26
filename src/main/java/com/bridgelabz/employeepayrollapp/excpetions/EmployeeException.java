package com.bridgelabz.employeepayrollapp.excpetions;

public class EmployeeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9027137471020875050L;
	private int statusCode;
	private String msg;
	
	public EmployeeException(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

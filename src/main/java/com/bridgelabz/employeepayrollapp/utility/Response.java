package com.bridgelabz.employeepayrollapp.utility;

public class Response {
	
	private int statusCode;
	private String reponseText;
	
	
	public Response(int statusCode, String reponseText) {
		this.statusCode = statusCode;
		this.reponseText = reponseText;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getReponseText() {
		return reponseText;
	}
	public void setReponseText(String reponseText) {
		this.reponseText = reponseText;
	}
	
	
	
}

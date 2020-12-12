package com.bridgelabz.employeepayrollapp.utility;

import lombok.Data;

public class Response {
	
	private int statusCode;
	private String reponseText;
	private Object obj;
	
	public Response(int statusCode, String reponseText) {
		this.statusCode = statusCode;
		this.reponseText = reponseText;
	}
	
	public Response(int statusCode, String reponseText,Object obj) {
		this.statusCode = statusCode;
		this.reponseText = reponseText;
		this.obj = obj;
	}

}

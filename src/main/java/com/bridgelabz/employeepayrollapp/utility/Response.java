package com.bridgelabz.employeepayrollapp.utility;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.Employee;

public class Response {
	
	private int statusCode;
	private String reponseText;
//	private Object obj;
	private List<Employee> empList;
	
	public Response(int statusCode, String reponseText) {
		this.statusCode = statusCode;
		this.reponseText = reponseText;
	}
	
	
	public Response(int statusCode, String reponseText,List<Employee> empList) {
		this.statusCode = statusCode;
		this.reponseText = reponseText;
		this.empList = empList;
	}
	
	
	

	public List<Employee> getEmpList() {
		return empList;
	}


	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
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


	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", reponseText=" + reponseText + ", empList=" + empList + "]";
	}


	
	
	
	
}

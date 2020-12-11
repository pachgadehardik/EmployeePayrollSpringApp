package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDTO {
	
	@NotNull
	@Size(min = 3, message = "Enter more than 3 characters")
	private String empName;
	@NotNull
	private Long salary;
		
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "{\"empName\":\"" + empName + "\", \"salary\":" + salary + "}";
	}
	

}

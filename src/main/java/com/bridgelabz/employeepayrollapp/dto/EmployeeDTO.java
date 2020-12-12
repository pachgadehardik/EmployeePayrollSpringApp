package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class EmployeeDTO {
	
	@NotNull
	@Size(min = 3, message = "Enter more than 3 characters")
	private String empName;
	@NotNull
	private Long salary;
		
}

package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class EmployeeDTO {

    @NotNull(message = "employee Name cant be null")
    @Size(min = 3, message = "Enter more than 3 characters")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is Invalid")
    private String empName;

    @NotNull
    @Min(value = 10000, message = "Salary should be more than 10000")
    private Long salary;
    
    @NotNull
    private String gender;
    
    private String department;
    
}

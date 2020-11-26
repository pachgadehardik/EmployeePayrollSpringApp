package com.bridgelabz.employeepayrollapp.dto;

public class EmployeeDTO {
	
	private Long id;
	private String empName;
	private Long salary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", salary=" + salary + "]";
	}
	
	

}

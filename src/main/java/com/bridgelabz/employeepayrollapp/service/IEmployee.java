package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployee {
	void addEmployee(Employee employee);

	public List<Employee> getEmployee();

	Employee getEmployeeById(long empId);
	
	Employee editEmployee(Employee employee);

	void deleteEmployee(long empId);
}

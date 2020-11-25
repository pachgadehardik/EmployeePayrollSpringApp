package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployee iEmployee;
	
	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		iEmployee.addEmployee(employee);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
		return iEmployee.getEmployee();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long empId) {
		return iEmployee.getEmployeeById(empId);
	}
	
	@PutMapping("/updateEmployee")
	public void edit(@RequestBody Employee employee) {
		iEmployee.editEmployee(employee);
	}
	
	
	@GetMapping("delete/{empId}")
    public void deleteEmployee(@PathVariable("empId") long empId) {
		iEmployee.deleteEmployee(empId);
	}
	
	
}

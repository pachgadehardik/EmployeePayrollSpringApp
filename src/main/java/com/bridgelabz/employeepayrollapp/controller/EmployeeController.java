package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.utility.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployee iEmployee;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Response response = iEmployee.addEmployee(employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<Response> getEmployee() {
		Response response = iEmployee.getEmployee();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee/{id}")
	public  ResponseEntity<Response> getEmployeeById(@PathVariable("id") long empId) {
		Response response = iEmployee.getEmployeeById(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public  ResponseEntity<Response> edit(@PathVariable("id") long id,@RequestBody EmployeeDTO employeeDTO) {
		Response response = iEmployee.editEmployee(id, employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("delete/{empId}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("empId") long empId) {
		Response response = iEmployee.deleteEmployee(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
}

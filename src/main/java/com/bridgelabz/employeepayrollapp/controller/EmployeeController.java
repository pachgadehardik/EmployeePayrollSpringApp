package com.bridgelabz.employeepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.UserDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.service.IUser;
import com.bridgelabz.employeepayrollapp.utility.Response;
import com.bridgelabz.employeepayrollapp.utility.TokenHelper;

import io.jsonwebtoken.Claims;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployee iEmployee;
	
	@Autowired
	private TokenHelper tokenHelper;
	
	@Autowired
	private IUser iUser;
	
	/**
	 * @param employeeDTO
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Response response = iEmployee.addEmployee(employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@GetMapping("/getEmployee")
	public ResponseEntity<Response> getEmployee(@RequestHeader("Authorization") String token) {
		Claims claims = tokenHelper.decodeJWT(token);
		System.out.println("ClaimsID: "+ claims.getId());
		Response response = iEmployee.getEmployee();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/**
	 * @param empId
	 * @return
	 */
	@GetMapping("/getEmployee/{id}")
	public  ResponseEntity<Response> getEmployeeById(@PathVariable("id") long empId) {
		Response response = iEmployee.getEmployeeById(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @param employeeDTO
	 * @return
	 */
	@PutMapping("/update/{id}")
	public  ResponseEntity<Response> edit(@PathVariable("id") long id,@Valid @RequestBody EmployeeDTO employeeDTO) {
		Response response = iEmployee.editEmployee(id, employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	/**
	 * @param empId
	 * @return
	 */
	@GetMapping("delete/{empId}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("empId") long empId) {
		Response response = iEmployee.deleteEmployee(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/**
	 * @param userDTO
	 * @return
	 */
	@RequestMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody UserDTO userDTO){
		
		Response response = iUser.loginUser(userDTO);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}
	
	
}

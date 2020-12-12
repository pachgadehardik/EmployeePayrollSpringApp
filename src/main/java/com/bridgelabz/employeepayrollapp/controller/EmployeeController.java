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
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.service.IUser;
import com.bridgelabz.employeepayrollapp.utility.Response;
import com.bridgelabz.employeepayrollapp.utility.TokenHelper;

/**
 * @author hardi
 *
 */
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
	 * Redirects to the add employee api in the service layer
	 */
	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@RequestHeader("Authorization") String token,
			@Valid @RequestBody EmployeeDTO employeeDTO) {
		tokenHelper.decodeJWT(token);
		Response response = iEmployee.addEmployee(employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	/**
	 * @return
	 * Redirects to the retrieve all employees from the service layer
	 */
	@GetMapping("/getEmployee")
	public ResponseEntity<Response> getEmployee(@RequestHeader("Authorization") String token) {
		tokenHelper.decodeJWT(token);
		Response response = iEmployee.getEmployee();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	/**
	 * @param empId
	 * @return
	 * Redirects to retrieve employee by passing the id in the URL
	 */
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Response> getEmployeeById(@RequestHeader("Authorization") String token,
			@PathVariable("id") long empId) {
		tokenHelper.decodeJWT(token);
		Response response = iEmployee.getEmployeeById(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param employeeDTO
	 * @return
	 * Redirects to Update employee by id from the service layer
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> edit(@RequestHeader("Authorization") String token, @PathVariable("id") long id,
			@Valid @RequestBody EmployeeDTO employeeDTO) {
		tokenHelper.decodeJWT(token);
		Response response = iEmployee.editEmployee(id, employeeDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	/**
	 * @param empId
	 * @return
	 * Redirects to delete employee by id from the service layer
	 */
	@GetMapping("delete/{empId}")
	public ResponseEntity<Response> deleteEmployee(@RequestHeader("Authorization") String token,
			@PathVariable("empId") long empId) {
		tokenHelper.decodeJWT(token);
		Response response = iEmployee.deleteEmployee(empId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	/**
	 * @param userDTO
	 * @return
	 * Redirects to Login the user by providing the credentials from the service layer
	 */
	@RequestMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody UserDTO userDTO) {

		Response response = iUser.loginUser(userDTO);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}

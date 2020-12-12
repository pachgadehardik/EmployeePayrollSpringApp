package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.excpetions.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.utility.IMessage;
import com.bridgelabz.employeepayrollapp.utility.Response;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hardi
 *Service Class which contains API logics
 */
@Service
@Slf4j
public class EmployeeImpl implements IEmployee {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 *Adding Employee to DB
	 */
	@Override
	public Response addEmployee(EmployeeDTO employeeDTO) {
		Optional<Employee> employee = empRepository.findByEmpName(employeeDTO.getEmpName());
		if(employee.isPresent()) {
			log.info("Employee Already Exists");
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), IMessage.EMPLOYEE_ALREADY_EXISTS);
		}
		
		Employee emp = modelMapper.map(employeeDTO, Employee.class);
		empRepository.save(emp);
		log.info("Employee Added in the Db");
		return new Response(HttpStatus.OK.value(), IMessage.USER_ADDED_MESSAGE);
	}
	
	/**
	 *Fetching Employee from DB
	 */
	@Override
	public Response getEmployee() {
		List<Employee> listEmployee = empRepository.findAll();
		if(listEmployee.isEmpty()) {
			throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employees Not Found");
		}
		log.info("Employee List Retrieved");
		return new Response(HttpStatus.OK.value(), HttpStatus.OK.name(),listEmployee.toArray());
	}

	/**
	 *Fetching Employee from DB by providing Id
	 */
	@Override
	public Response getEmployeeById(long empId) {
		Employee employee = empRepository.findById(empId).orElseThrow(() -> 
			new EmployeeException(HttpStatus.NO_CONTENT.value(), IMessage.EMPLOYEE_NOT_FOUND));
		return new Response(HttpStatus.OK.value(), employee.toString());
	}

	/**
	 *Updating Employee from DB by providing Id
	 */
	@Override
	public Response editEmployee(long id, EmployeeDTO employeeDTO) {
		Employee checkEmployeeExists = empRepository.findById(id).orElse(null);
		if(checkEmployeeExists == null) {
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), IMessage.EMPLOYEE_NOT_FOUND);
		}
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employee.setId(id);
		empRepository.save(employee);
		return new Response(HttpStatus.OK.value(), "Employee Updated!");
		
	}

	/**
	 *Deleting Employee from DB by providing Id
	 */
	@Override
	public Response deleteEmployee(long empId) {
		Employee checkEmployeeExists = empRepository.findById(empId).orElse(null);
		if(checkEmployeeExists == null) {
			throw new EmployeeException(HttpStatus.NOT_MODIFIED.value(), IMessage.EMPLOYEE_NOT_FOUND);
		}
		empRepository.deleteById(empId);
		return new Response(HttpStatus.OK.value(), IMessage.EMPLOYEE_DELETED);
	}
	


}

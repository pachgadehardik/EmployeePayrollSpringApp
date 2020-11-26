package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.excpetions.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.utility.Response;

@Service
public class EmployeeImpl implements IEmployee {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Response addEmployee(EmployeeDTO employeeDTO) {
		Optional<Employee> employee = empRepository.findByEmpName(employeeDTO.getEmpName());
		if(employee.isPresent()) {
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), "Employee Already Exists!");
		}
		
		Employee emp = modelMapper.map(employeeDTO, Employee.class);
		empRepository.save(emp);
		return new Response(HttpStatus.OK.value(), "Employee Added Successfully!!");
	}

	@Override
	public Response getEmployee() {
		List<Employee> listEmployee = empRepository.findAll();
		if(listEmployee.isEmpty()) {
			throw new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employees Not Found");
		}
		List<EmployeeDTO> listEmployeeDTO =  listEmployee.stream().map(emp ->{return modelMapper.map(emp, EmployeeDTO.class);}).collect(Collectors.toList());
		return new Response(HttpStatus.OK.value(), listEmployeeDTO.toString());
	}

	@Override
	public Response getEmployeeById(long empId) {
		Employee employee = empRepository.findById(empId).orElseThrow(() -> 
			new EmployeeException(HttpStatus.NO_CONTENT.value(), "Employee Not Found"));
		return new Response(HttpStatus.OK.value(), employee.toString());
	}

	@Override
	public Response editEmployee(long id, EmployeeDTO employeeDTO) {
		Employee checkEmployeeExists = empRepository.findById(id).orElse(null);
		if(checkEmployeeExists == null) {
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), "Employee Does Not Exists!!");
		}
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employee.setId(id);
		empRepository.save(employee);
		return new Response(HttpStatus.OK.value(), "Employee Updated!");
		
	}

	@Override
	public Response deleteEmployee(long empId) {
		Employee checkEmployeeExists = empRepository.findById(empId).orElse(null);
		if(checkEmployeeExists == null) {
			throw new EmployeeException(HttpStatus.NOT_MODIFIED.value(), "Employee Does Not Exists!!");
		}
		empRepository.deleteById(empId);
		return new Response(HttpStatus.OK.value(), "Employee Deleted!");
	}
	


}

package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployee;

@Service
public class EmployeeImpl implements IEmployee {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public void addEmployee(Employee employee) {

		empRepository.save(employee);
		System.out.println("Data Added!");
	}

	@Override
	public List<Employee> getEmployee() {
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long empId) {
		return empRepository.findById(empId).get();
	}

	@Override
	public Employee editEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long empId) {
		empRepository.deleteById(empId);
	}

}

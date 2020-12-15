package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.utility.Response;

public interface IEmployee {
    Response addEmployee(EmployeeDTO employeeDTO);

    public Response getEmployee();

    Response getEmployeeById(long empId);

    Response editEmployee(long id, EmployeeDTO employeeDTO);

    Response deleteEmployee(long empId);
}

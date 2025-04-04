package com.ems.ems_backend.service;

import java.util.List;

import com.ems.ems_backend.dto.EmployeeDto;

public interface EmployeeService {

	// Create
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	// Get employee
	EmployeeDto getEmployeeById(Long employeeId);

	// Get all employees
	List<EmployeeDto> getAllEmployees();

	// Update employee
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
	
	// Delete Employee
	void deleteEmployee(Long employeeId);
	
}

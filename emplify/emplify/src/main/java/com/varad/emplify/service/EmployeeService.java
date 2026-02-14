package com.varad.emplify.service;

import java.util.List;

import com.varad.emplify.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long id);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

	void deleteEmployee(Long id);

	List<EmployeeDto> getEmployeesByName(String name);

}

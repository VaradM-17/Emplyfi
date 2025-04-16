package com.ems.ems_backend.mapper;

import com.ems.ems_backend.dto.EmployeeDto;
import com.ems.ems_backend.entity.Employee;

public class EmployeeMapper {

	// Converts Employee entity to EmployeeDto
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
			employee.getId(),
			employee.getFirstName(),
			employee.getLastName(),
			employee.getEmail(),
			employee.getDepartment().getId(),
			employee.getDepartment().getDepartmentName()
		);
	}


	// Converts EmployeeDto to Employee entity
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		return employee;
	}
}

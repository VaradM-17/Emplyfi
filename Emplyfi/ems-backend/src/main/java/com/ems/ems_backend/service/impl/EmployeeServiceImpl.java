package com.ems.ems_backend.service.impl;

import org.springframework.stereotype.Service;
import com.ems.ems_backend.dto.EmployeeDto;
import com.ems.ems_backend.entity.Employee;
import com.ems.ems_backend.mapper.EmployeeMapper;
import com.ems.ems_backend.repository.EmployeeRepository;
import com.ems.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		// Convert EmployeeDto (received from frontend) to Employee entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		// Save the Employee entity into the database using JPA's save() method
		Employee savedEmployee = employeeRepository.save(employee);
		
		// Convert the saved Employee entity back to EmployeeDto and return it
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
}

package com.varad.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.varad.ems.dto.EmployeeDto;
import com.varad.ems.entity.Department;
import com.varad.ems.entity.Employee;
import com.varad.ems.exception.ResourceNotFoundException;
import com.varad.ems.mapper.AutoEmployeeMapper;
import com.varad.ems.repository.DepartmentRepository;
import com.varad.ems.repository.EmployeeRepository;
import com.varad.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	// department dependency
	private final DepartmentRepository departmentRepository;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"department does not exist by id: " + employeeDto.getDepartmentId()));

		Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
		// attach department to employee
		employee.setDepartment(department);

		Employee saveEmployee = employeeRepository.save(employee);

		return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(saveEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists by id: " + id));

		return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();

		return employees.stream().map((employee) -> AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists by id: " + id));

		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"department does not exist by id: " + employeeDto.getDepartmentId()));

		
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(department);

		Employee updateEmployee = employeeRepository.save(employee);

		return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(updateEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists by id: " + id));

		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> getEmployeesByName(String name) {
		List<Employee> employees = employeeRepository.findByFirstName(name);
		return employees.stream().map((employee) -> AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

}

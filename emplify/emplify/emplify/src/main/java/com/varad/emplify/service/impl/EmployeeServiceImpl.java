package com.varad.emplify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.varad.emplify.dto.EmployeeDto;
import com.varad.emplify.entity.Department;
import com.varad.emplify.entity.Employee;
import com.varad.emplify.exception.ResourceNotFoundException;
import com.varad.emplify.repository.DepartmentRepository;
import com.varad.emplify.repository.EmployeeRepository;
import com.varad.emplify.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Department does not exist by id: " + employeeDto.getDepartmentId()));

		Employee employee = modelMapper.map(employeeDto, Employee.class);
		employee.setDepartment(department);

		Employee savedEmployee = employeeRepository.save(employee);

		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist by id: " + id));

		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();

		return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist by id: " + id));

		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Department does not exist by id: " + employeeDto.getDepartmentId()));

		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(department);

		Employee updatedEmployee = employeeRepository.save(employee);

		return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist by id: " + id));

		employeeRepository.delete(employee);
	}

	@Override
	public List<EmployeeDto> getEmployeesByName(String name) {

		List<Employee> employees = employeeRepository.findByFirstName(name);

		return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());
	}
}

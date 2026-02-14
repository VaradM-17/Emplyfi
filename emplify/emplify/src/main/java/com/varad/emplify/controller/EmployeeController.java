package com.varad.emplify.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.varad.emplify.dto.EmployeeDto;
import com.varad.emplify.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Employee Controller", description = "CRUD operations for employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	// CREATE employee
	@PostMapping
	@Operation(summary = "Create a new employee", description = "Creates a new employee and returns the created resource")
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @org.springframework.web.bind.annotation.RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Employee to create", required = true) EmployeeDto employeeDto) {

		EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// GET employee by id
	@GetMapping("/{id}")
	@Operation(summary = "Get employee by id", description = "Returns a single employee by its id")
	public ResponseEntity<EmployeeDto> getEmployeeById(@Parameter(description = "ID of the employee to retrieve", required = true) @PathVariable Long id) {

		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDto);
	}

	// GET all employees
	@GetMapping
	@Operation(summary = "Get all employees", description = "Returns a list of all employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// UPDATE employee
	@PutMapping("/{id}")
	@Operation(summary = "Update an employee", description = "Updates an existing employee by id and returns the updated resource")
	public ResponseEntity<EmployeeDto> updateEmployee(@Parameter(description = "ID of the employee to update", required = true) @PathVariable Long id,
			@Valid @org.springframework.web.bind.annotation.RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Updated employee", required = true) EmployeeDto employeeDto) {

		EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);

		return ResponseEntity.ok(updatedEmployee);
	}

	// DELETE employee
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete an employee", description = "Deletes an employee by id")
	public ResponseEntity<String> deleteEmployee(@Parameter(description = "ID of the employee to delete", required = true) @PathVariable Long id) {

		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully with id: " + id);
	}

	// GET employees by first name
	@GetMapping("/search")
	@Operation(summary = "Search employees by name", description = "Searches employees by first name (query param 'name')")
	public ResponseEntity<List<EmployeeDto>> getEmployeesByName(@Parameter(description = "First name to search for", required = true) @RequestParam String name) {

		List<EmployeeDto> employees = employeeService.getEmployeesByName(name);

		return ResponseEntity.ok(employees);
	}
}
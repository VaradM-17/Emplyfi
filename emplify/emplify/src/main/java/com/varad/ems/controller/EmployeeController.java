package com.varad.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.varad.ems.dto.EmployeeDto;
import com.varad.ems.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RequestMapping("/api/employees")
@RestController
@Tag(name = "Employee API", description = "Operations related to employee management")
public class EmployeeController {

	private final EmployeeService employeeService;

	// ----------------------------------------------
	// ADD EMPLOYEE
	// ----------------------------------------------
	@Operation(summary = "Add new employee", description = "Creates a new employee record")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Employee created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid employee data", content = @Content(schema = @Schema(hidden = true))) })
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

		EmployeeDto employee = employeeService.addEmployee(employeeDto);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	// ----------------------------------------------
	// GET EMPLOYEE BY ID
	// ----------------------------------------------
	@Operation(summary = "Get employee by ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employee found"),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(schema = @Schema(hidden = true))) })
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@Parameter(description = "Employee ID") @PathVariable Long id) {

		EmployeeDto employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	// ----------------------------------------------
	// GET ALL EMPLOYEES
	// ----------------------------------------------
	@Operation(summary = "Get all employees")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "List of employees returned") })
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// ----------------------------------------------
	// UPDATE EMPLOYEE
	// ----------------------------------------------
	@Operation(summary = "Update employee details")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
			@ApiResponse(responseCode = "404", description = "Employee not found") })
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@Parameter(description = "Employee ID") @PathVariable Long id,
			@Valid @RequestBody EmployeeDto employeeDto) {

		EmployeeDto updateEmployee = employeeService.updateEmployee(id, employeeDto);
		return ResponseEntity.ok(updateEmployee);
	}

	// ----------------------------------------------
	// DELETE EMPLOYEE
	// ----------------------------------------------
	@Operation(summary = "Delete employee", description = "Deletes an employee by ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employee deleted"),
			@ApiResponse(responseCode = "404", description = "Employee not found") })
	@DeleteMapping("/{id}")
	public String deleteEmployee(@Parameter(description = "Employee ID") @PathVariable Long id) {

		employeeService.deleteEmployee(id);
		return "Employee data deleted";
	}

	// ----------------------------------------------
	// SEARCH BY NAME
	// ----------------------------------------------
	@Operation(summary = "Search employees by name")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees found"),
			@ApiResponse(responseCode = "404", description = "No employees matched the name", content = @Content(schema = @Schema(hidden = true))) })
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeDto>> getEmployeesByName(
			@Parameter(description = "Search keyword by employee name") @RequestParam String name) {

		List<EmployeeDto> employees = employeeService.getEmployeesByName(name);
		return ResponseEntity.ok(employees);
	}
}

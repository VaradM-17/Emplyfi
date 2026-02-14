package com.varad.emplify.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.varad.emplify.dto.DepartmentDto;
import com.varad.emplify.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Tag(name = "Department Controller", description = "CRUD operations for departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	// CREATE department
	@PostMapping
	@Operation(summary = "Create a new department", description = "Creates a new department and returns the created resource")
	public ResponseEntity<DepartmentDto> addDepartment(@Valid @org.springframework.web.bind.annotation.RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Department to create", required = true) DepartmentDto departmentDto) {

		DepartmentDto savedDepartment = departmentService.addDepartment(departmentDto);

		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	// GET department by id
	@GetMapping("/{id}")
	@Operation(summary = "Get department by id", description = "Returns a single department by its id")
	public ResponseEntity<DepartmentDto> getDepartmentById(@Parameter(description = "ID of the department to retrieve", required = true) @PathVariable Long id) {

		DepartmentDto departmentDto = departmentService.getDepartmentById(id);

		return ResponseEntity.ok(departmentDto);
	}

	// GET all departments
	@GetMapping
	@Operation(summary = "Get all departments", description = "Returns a list of all departments")
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

		List<DepartmentDto> departments = departmentService.getAllDepartments();

		return ResponseEntity.ok(departments);
	}

	// UPDATE department
	@PutMapping("/{id}")
	@Operation(summary = "Update a department", description = "Updates an existing department by id and returns the updated resource")
	public ResponseEntity<DepartmentDto> updateDepartment(@Parameter(description = "ID of the department to update", required = true) @PathVariable Long id,
			@Valid @org.springframework.web.bind.annotation.RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Updated department", required = true) DepartmentDto dto) {

		DepartmentDto updatedDepartment = departmentService.updateDepartment(id, dto);

		return ResponseEntity.ok(updatedDepartment);
	}

	// DELETE department
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a department", description = "Deletes a department by id")
	public ResponseEntity<String> deleteDepartment(@Parameter(description = "ID of the department to delete", required = true) @PathVariable Long id) {

		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Department deleted successfully with id: " + id);
	}
}
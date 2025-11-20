package com.varad.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.varad.ems.dto.DepartmentDto;
import com.varad.ems.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Department API", description = "CRUD operations related to departments")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RequestMapping("/api/departments")
@RestController
public class DepartmentController {

	private final DepartmentService departmentService;

	// ---------------------------------------------------------
	// Add Department
	// ---------------------------------------------------------
	@Operation(summary = "Add new department", description = "Creates a new department")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Department created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid data", content = @Content(schema = @Schema(hidden = true))) })
	@PostMapping
	public ResponseEntity<DepartmentDto> addDepartment(@Valid @RequestBody DepartmentDto departmentDto) {

		DepartmentDto department = departmentService.addDepartment(departmentDto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}

	// ---------------------------------------------------------
	// Get Department by ID
	// ---------------------------------------------------------
	@Operation(summary = "Get department by ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Department found"),
			@ApiResponse(responseCode = "404", description = "Department not found", content = @Content(schema = @Schema(hidden = true))) })
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartment(
			@Parameter(description = "Department ID") @PathVariable Long id) {

		DepartmentDto department = departmentService.getDepartmentById(id);
		return ResponseEntity.ok(department);
	}

	// ---------------------------------------------------------
	// Get All Departments
	// ---------------------------------------------------------
	@Operation(summary = "Get all departments")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "List of departments returned") })
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

		List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}

	// ---------------------------------------------------------
	// Update Department
	// ---------------------------------------------------------
	@Operation(summary = "Update department details")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Department updated successfully"),
			@ApiResponse(responseCode = "404", description = "Department not found") })
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(
			@Parameter(description = "Department ID") @PathVariable Long id,
			@Valid @RequestBody DepartmentDto departmentDto) {

		DepartmentDto updateDepartment = departmentService.updateDepartment(id, departmentDto);
		return ResponseEntity.ok(updateDepartment);
	}

	// ---------------------------------------------------------
	// Delete Department
	// ---------------------------------------------------------
	@Operation(summary = "Delete department")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Department deleted"),
			@ApiResponse(responseCode = "404", description = "Department not found") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@Parameter(description = "Department ID") @PathVariable Long id) {

		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("department deleted.");
	}
}

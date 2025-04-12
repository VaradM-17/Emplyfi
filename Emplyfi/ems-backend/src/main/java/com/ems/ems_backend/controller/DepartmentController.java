package com.ems.ems_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.ems_backend.dto.DepartmentDto;
import com.ems.ems_backend.entity.Department;
import com.ems.ems_backend.service.impl.DepartmentServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin("/")
@RequestMapping("/departments")
@RestController
public class DepartmentController {

	private DepartmentServiceImpl departmentServiceImpl;

	// Create
	@PostMapping("/create")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentServiceImpl.createDepartment(departmentDto);

		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	// Update
	@PutMapping("/updateDepartment/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
			@RequestBody DepartmentDto departmentDto) {
		DepartmentDto updateDepartment = departmentServiceImpl.updateDepartment(departmentId, departmentDto);

		return ResponseEntity.ok(updateDepartment);
	}

	// Delete
	@DeleteMapping("/deleteDepartment/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
		departmentServiceImpl.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department successfully deleted");
	}
	

}
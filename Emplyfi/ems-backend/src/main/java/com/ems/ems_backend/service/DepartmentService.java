package com.ems.ems_backend.service;

import java.util.List;

import com.ems.ems_backend.dto.DepartmentDto;

public interface DepartmentService {

	// create
	DepartmentDto createDepartment(DepartmentDto departmentDto);

	// update
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment);

	// delete
	void deleteDepartment(Long departmentId);
	
	// get all
    List<DepartmentDto> getAllDepartment();
	
	// get single department
	DepartmentDto getDepartmentById(Long departmentId);
}
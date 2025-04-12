package com.ems.ems_backend.service;

import java.util.List;

import com.ems.ems_backend.dto.DepartmentDto;

public interface DepartmentService {

	// create
	public DepartmentDto createDepartment(DepartmentDto departmentDto);

	// update
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment);

	// delete
	public void deleteDepartment(Long departmentId);
	
	// get all
	public List<DepartmentDto> getAllDepartment();
	
	// get single department
	public DepartmentDto getDepartmentById(Long departmentId);
}
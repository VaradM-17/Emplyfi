package com.ems.ems_backend.service;

import com.ems.ems_backend.dto.DepartmentDto;

public interface DepartmentService {

	// create
	public DepartmentDto createDepartment(DepartmentDto departmentDto);

	// update
	public DepartmentDto updateDepartment(Long id, DepartmentDto updateDepartment);

	// delete
	public void deleteDepartment(Long id);
}
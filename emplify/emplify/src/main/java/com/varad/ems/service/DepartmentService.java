package com.varad.ems.service;

import java.util.List;

import com.varad.ems.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto addDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentById(Long id);

	List<DepartmentDto> getAllDepartments();

	DepartmentDto updateDepartment(Long id, DepartmentDto dto);

	void deleteDepartment(Long id);
}

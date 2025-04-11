package com.ems.ems_backend.service.impl;

import org.springframework.stereotype.Service;

import com.ems.ems_backend.dto.DepartmentDto;
import com.ems.ems_backend.entity.Department;
import com.ems.ems_backend.mapper.DepartmentMapper;
import com.ems.ems_backend.repository.DepartmentRepository;
import com.ems.ems_backend.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentrepository;

	// create
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentdto) {
		Department department = DepartmentMapper.mapToDepartment(departmentdto);
		Department savedDepartment = departmentrepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
	
}
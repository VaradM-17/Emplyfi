package com.ems.ems_backend.service.impl;

import org.springframework.stereotype.Service;

import com.ems.ems_backend.dto.DepartmentDto;
import com.ems.ems_backend.entity.Department;
import com.ems.ems_backend.exception.ResourceNotFoundException;
import com.ems.ems_backend.mapper.DepartmentMapper;
import com.ems.ems_backend.repository.DepartmentRepository;
import com.ems.ems_backend.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	// Create
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	// Update
	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found by Id : " + id));
		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setDepartmentDescription(departmentDto.getDepartmentDescription());

		Department savedDepartment = departmentRepository.save(department);

		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}
}
package com.varad.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.varad.ems.dto.DepartmentDto;
import com.varad.ems.entity.Department;
import com.varad.ems.exception.ResourceNotFoundException;
import com.varad.ems.mapper.AutoDepartmentMapper;
import com.varad.ems.repository.DepartmentRepository;
import com.varad.ems.service.DepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
		Department saveDepartment = departmentRepository.save(department);
		return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(saveDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found by " + id));
		return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		return departmentRepository.findAll().stream()
				.map((department) -> AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto dto) {
		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found" + id));

		dept.setDepartmentName(dto.getDepartmentName());

		Department updated = departmentRepository.save(dept);
		return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(updated);
	}

	@Override
	public void deleteDepartment(Long id) {
		Department dept = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found" + id));
		departmentRepository.delete(dept);
	}
}

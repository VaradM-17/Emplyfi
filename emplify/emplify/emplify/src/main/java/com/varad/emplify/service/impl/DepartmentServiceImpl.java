package com.varad.emplify.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.varad.emplify.dto.DepartmentDto;
import com.varad.emplify.entity.Department;
import com.varad.emplify.exception.ResourceNotFoundException;
import com.varad.emplify.repository.DepartmentRepository;
import com.varad.emplify.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;

	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {

		Department department = modelMapper.map(departmentDto, Department.class);

		Department savedDepartment = departmentRepository.save(department);

		return modelMapper.map(savedDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department does not exist by id: " + id));

		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {

		List<Department> departments = departmentRepository.findAll();

		return departments.stream().map(department -> modelMapper.map(department, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto dto) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department does not exist by id: " + id));

		department.setDepartmentName(dto.getDepartmentName());
		department.setDepartmentDescription(dto.getDepartmentDescription());

		Department updatedDepartment = departmentRepository.save(department);

		return modelMapper.map(updatedDepartment, DepartmentDto.class);
	}

	@Override
	public void deleteDepartment(Long id) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department does not exist by id: " + id));

		departmentRepository.delete(department);
	}
}

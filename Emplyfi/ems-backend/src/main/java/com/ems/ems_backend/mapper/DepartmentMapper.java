package com.ems.ems_backend.mapper;

import com.ems.ems_backend.dto.DepartmentDto;
import com.ems.ems_backend.entity.Department;

public class DepartmentMapper {

	// convert department entity to department dto
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription());
	}

	// convert departmentdto to department entity
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription());
	}
}
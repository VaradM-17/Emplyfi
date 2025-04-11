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
	public static Department mapToDepartment(DepartmentDto departmentdto) {
		return new Department(departmentdto.getId(), departmentdto.getDepartmentName(),
				departmentdto.getDepartmentDescription());
	}
}
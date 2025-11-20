package com.varad.ems.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.varad.ems.dto.DepartmentDto;
import com.varad.ems.entity.Department;

@Mapper
public interface AutoDepartmentMapper {
	AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

	DepartmentDto mapToDepartmentDto(Department department);
	Department mapToDepartment(DepartmentDto departmentDto);
}

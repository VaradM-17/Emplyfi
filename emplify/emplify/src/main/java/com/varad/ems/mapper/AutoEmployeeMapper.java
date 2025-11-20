package com.varad.ems.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.varad.ems.dto.EmployeeDto;
import com.varad.ems.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {

	AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

	@Mapping(source = "department.id", target = "departmentId")
	@Mapping(source = "department.departmentName", target = "departmentName")
	EmployeeDto mapToEmployeeDto(Employee employee);

	@Mapping(target = "department.id", source = "departmentId")
	@Mapping(target = "department.departmentName", source = "departmentName")
	Employee mapToEmployee(EmployeeDto employeeDto);
}

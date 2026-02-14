package com.varad.emplify.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Department", description = "Department data transfer object")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

	@Schema(description = "Unique identifier of the department", example = "1")
	private Long id;
	
	@NotEmpty(message = "Department name must not be empty")
	@Schema(description = "Name of the department", example = "Engineering", required = true)
	private String departmentName;

	@NotEmpty(message = "Department description must not be empty")
	@Schema(description = "Description of the department", example = "Handles product development", required = true)
	private String departmentDescription;
}
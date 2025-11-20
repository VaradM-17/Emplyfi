package com.varad.ems.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Department data transfer object")
public class DepartmentDto {

	@Schema(description = "Department ID", example = "10")
	private Long id;

	@NotEmpty
	@Schema(description = "Name of the department", example = "Human Resources")
	private String departmentName;

	@NotEmpty
	@Schema(description = "Brief description of the department", example = "Handles employee relations and hiring")
	private String departmentDescription;
}

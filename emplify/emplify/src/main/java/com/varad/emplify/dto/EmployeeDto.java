package com.varad.emplify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Employee", description = "Employee data transfer object")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	@Schema(description = "Unique identifier of the employee", example = "1")
	private Long id;

	@NotEmpty(message = "First name is required")
	@Schema(description = "First name of the employee", example = "John", required = true)
	private String firstName;

	@NotEmpty(message = "Last name is required")
	@Schema(description = "Last name of the employee", example = "Doe", required = true)
	private String lastName;

	@NotEmpty(message = "Email is required")
	@Schema(description = "Email address of the employee", example = "john.doe@example.com", required = true)
	private String email;

	@NotNull(message = "Department ID is required")
	@Schema(description = "ID of the department the employee belongs to", example = "2", required = true)
	private Long departmentId;

	@Schema(description = "Name of the department", example = "Engineering")
	private String departmentName;

}
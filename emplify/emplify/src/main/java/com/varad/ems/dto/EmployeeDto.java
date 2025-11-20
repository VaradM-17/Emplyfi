package com.varad.ems.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee data transfer object")
public class EmployeeDto {

	@Schema(description = "Employee ID", example = "1")
	private Long id;

	@NotEmpty
	@Schema(description = "Employee first name", example = "Varad", required = true)
	private String firstName;

	@NotEmpty
	@Schema(description = "Employee last name", example = "Mule", required = true)
	private String lastName;

	@NotEmpty
	@Schema(description = "Employee email address", example = "john.doe@example.com", required = true)
	private String email;

	@NotNull
	@Schema(description = "ID of the department employee belongs to", example = "3", required = true)
	private Long departmentId;

	@Schema(description = "Department name (auto-filled)", example = "IT")
	private String departmentName;
}

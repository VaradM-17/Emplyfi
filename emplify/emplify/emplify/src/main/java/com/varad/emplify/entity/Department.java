package com.varad.emplify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
@Schema(name = "DepartmentEntity", description = "Department JPA entity")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Unique identifier of the department", example = "1")
	private Long id;

	@Column(name = "department_name", nullable = false, unique = true)
	@Schema(description = "Name of the department", example = "Engineering", required = true)
	private String departmentName;

	@Column(name = "department_description", nullable = false)
	@Schema(description = "Description of the department", example = "Handles product development", required = true)
	private String departmentDescription;
}
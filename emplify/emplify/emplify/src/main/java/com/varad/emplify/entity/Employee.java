package com.varad.emplify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@Schema(name = "EmployeeEntity", description = "Employee JPA entity")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Unique identifier of the employee", example = "1")
	private Long id;

	@Column(name = "first_name", nullable = false)
	@Schema(description = "First name of the employee", example = "John", required = true)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@Schema(description = "Last name of the employee", example = "Doe", required = true)
	private String lastName;

	@Column(name = "email", unique = true, nullable = false)
	@Schema(description = "Email address of the employee", example = "john.doe@example.com", required = true)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@Schema(description = "Department entity this employee belongs to")
	private Department department;
}
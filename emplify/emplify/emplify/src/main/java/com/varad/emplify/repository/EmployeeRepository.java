package com.varad.emplify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varad.emplify.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByFirstName(String firstName);
}

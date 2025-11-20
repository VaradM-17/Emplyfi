package com.varad.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varad.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

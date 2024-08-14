package com.example.employeemanagementsystem.repository.department;

import com.example.employeemanagementsystem.model.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods if needed
}

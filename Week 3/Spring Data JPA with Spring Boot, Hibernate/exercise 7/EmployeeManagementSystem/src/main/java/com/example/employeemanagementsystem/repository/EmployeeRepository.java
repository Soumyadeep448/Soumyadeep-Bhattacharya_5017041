package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Paginated method to find all employees
    Page<Employee> findAll(Pageable pageable);

    // Paginated method to find employees by department ID
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
}

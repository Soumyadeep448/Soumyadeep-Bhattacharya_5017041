package com.example.employeemanagementsystem.repository.employee;

import com.example.employeemanagementsystem.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods if needed
}

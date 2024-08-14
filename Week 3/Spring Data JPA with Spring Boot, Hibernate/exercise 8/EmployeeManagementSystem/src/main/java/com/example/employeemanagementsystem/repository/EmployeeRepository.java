package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using Interface-based Projection
    @Query("SELECT e.id as id, e.name as name, e.email as email, d.name as departmentName FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();

    // Using Class-based Projection
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, d.name) " +
            "FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findAllEmployeeDTOs();

    // Example using constructor expression
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) " +
            "FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDTO> findEmployeeDTOsByDepartmentId(@Param("departmentId") Long departmentId);
}

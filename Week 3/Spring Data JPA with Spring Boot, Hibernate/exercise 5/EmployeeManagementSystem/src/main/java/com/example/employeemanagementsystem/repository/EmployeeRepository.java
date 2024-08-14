package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find employees by name
    List<Employee> findByName(String name);

    // Find employees by email
    Employee findByEmail(String email);

    // Find employees whose name contains a specific keyword
    List<Employee> findByNameContaining(String keyword);

    // Custom query to find employees by email domain
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain")
    List<Employee> findByEmailDomain(@Param("domain") String domain);
    

    // Use named query to find employees by department ID
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    // Use named query to find employees by email domain
    List<Employee> findByEmailDomain(@Param("domain") String domain);
}

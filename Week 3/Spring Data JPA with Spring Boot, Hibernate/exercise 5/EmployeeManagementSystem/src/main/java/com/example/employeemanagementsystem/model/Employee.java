package com.example.employeemanagementsystem.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByDepartmentId", 
                query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"),
    @NamedQuery(name = "Employee.findByEmailDomain", 
                query = "SELECT e FROM Employee e WHERE e.email LIKE :domain")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Getters and setters...
}

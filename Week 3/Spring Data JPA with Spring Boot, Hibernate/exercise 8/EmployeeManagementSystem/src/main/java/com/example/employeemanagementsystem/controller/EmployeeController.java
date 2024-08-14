package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Endpoint to get all employees with interface-based projection
    @GetMapping("/employees/projection")
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }

    // Endpoint to get all employees with class-based projection
    @GetMapping("/employees/dto")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }

    // Endpoint to get employees by department using class-based projection
    @GetMapping("/employees/dto/department")
    public List<EmployeeDTO> getEmployeeDTOsByDepartmentId(@RequestParam Long departmentId) {
        return employeeRepository.findEmployeeDTOsByDepartmentId(departmentId);
    }
}

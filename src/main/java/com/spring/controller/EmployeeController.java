package com.spring.controller;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }
    @GetMapping("/{empId}")
    public Optional<Employee> getEmployee(@PathVariable Integer empId){
        return employeeService.getEmp(empId);
    }
    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer empId){
        return employeeService.updateEmployee(employee, empId);
    }
}

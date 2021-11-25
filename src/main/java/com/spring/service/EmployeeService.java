package com.spring.service;

import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmp(Employee employee){
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmp(Integer empId){
        return employeeRepository.findById(empId);
    }
    public Employee updateEmployee(Employee employee, Integer empId){
        return employeeRepository.findById(empId)
                .map(emp -> {
                    emp.setName(employee.getName());
                    emp.setAddress(employee.getAddress());
                    emp.setEmail(employee.getEmail());
                    emp.setContactNo(employee.getContactNo());
                    return employeeRepository.save(emp);
                })
                .orElseGet(()->{
                    employee.setEmpId(empId);
                    return employeeRepository.save(employee);
                });
    }

}

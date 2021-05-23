package com.nweligalla.classman.service;

import com.nweligalla.classman.exception.UserNotFoundException;
import com.nweligalla.classman.model.Employee;
import com.nweligalla.classman.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {


    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //add Employee
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    //update Employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    //delete Employee
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    //get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User id" + id + "not found"));
    }
}

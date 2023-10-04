package com.geekster.EmployeeAddress.Service;

import com.geekster.EmployeeAddress.Model.Address;
import com.geekster.EmployeeAddress.Model.Employee;
import com.geekster.EmployeeAddress.Repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;


    public String addEmployee(Employee newEmployee) {
        employeeRepo.save(newEmployee);
        return "new employee added";
    }

    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    public Employee getEmployees(Integer id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            return employeeRepo.save(existingEmployee);
        } else {
            return null; // Employee with the given ID not found
        }
    }

    public String deleteEmployeesById(Integer id) {
        employeeRepo.deleteById(id);
        return "deleted";
    }
}

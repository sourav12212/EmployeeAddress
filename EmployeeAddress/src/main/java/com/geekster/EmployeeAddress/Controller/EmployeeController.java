package com.geekster.EmployeeAddress.Controller;

import com.geekster.EmployeeAddress.Model.Address;
import com.geekster.EmployeeAddress.Model.Employee;
import com.geekster.EmployeeAddress.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee newEmployee){
        return employeeService.addEmployee(newEmployee);

    }

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployees(@PathVariable Integer id){
        return employeeService.getEmployees(id);

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployeesById(@PathVariable Integer id){
        return employeeService.deleteEmployeesById(id);
    }


}

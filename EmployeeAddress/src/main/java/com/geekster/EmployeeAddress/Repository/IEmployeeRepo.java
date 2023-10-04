package com.geekster.EmployeeAddress.Repository;

import com.geekster.EmployeeAddress.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
}

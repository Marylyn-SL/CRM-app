package com.example.crm.Repository;

import com.example.crm.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}
package com.example.crm.Repository;

import com.example.crm.Model.Employee;
import com.example.crm.Model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findByEmployee(Employee employee);
}

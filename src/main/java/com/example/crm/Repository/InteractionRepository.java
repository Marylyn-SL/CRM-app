package com.example.crm.Repository;

import com.example.crm.Model.Employee;
import com.example.crm.Model.Customer;
import com.example.crm.Model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
}

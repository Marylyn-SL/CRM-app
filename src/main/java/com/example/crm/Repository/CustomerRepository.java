package com.example.crm.Repository;

import com.example.crm.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByIsCustomer(Boolean isCustomer);
    Customer findByEmail(String email);
}

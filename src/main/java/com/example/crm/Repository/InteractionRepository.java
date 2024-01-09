package com.example.crm.Repository;

import com.example.crm.Model.Employee;
import com.example.crm.Model.Customer;
import com.example.crm.Model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
//    List<Interaction> findByEmployee(Employee employee);
//    List<Interaction> findByCustomerAndDateBeforeAndCompletedIsFalse(Customer customer, Date date);
//    List<Interaction> findByCustomerAndDateBeforeAndCompletedIsTrue(Customer customer, Date date);
//    List<Interaction> findByCustomer_IsCustomerFalseAndDateBeforeAndCompletedIsFalse(Date date);
//    List<Interaction> findByCustomer_IsCustomerTrueAndDateBeforeAndCompletedIsTrue(Date date);
}

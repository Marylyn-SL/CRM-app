package com.example.crm.Controller;

import com.example.crm.Model.Interaction;
import com.example.crm.Model.Customer;
import com.example.crm.Repository.CustomerRepository;
import com.example.crm.Repository.InteractionRepository;
import com.example.crm.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MessageService messageService;

    @GetMapping("/customer")
    public String getCustomers(Model model, Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @PostMapping("/customer")
    public String addCustomer(Model model, @ModelAttribute Customer customer) {
        customerRepository.save(customer);
        List<Customer> customers = customerRepository.findAll();
        return "customer";
    }

//    @GetMapping("/inactive-customers")
//    public String getInactiveCustomers(Model model) {
//        Date sixMonthsAgo = null;
//
//        if (sixMonthsAgo != null) {
//            List<Interaction> inactiveCustomers = interactionRepository.findByCustomer_IsCustomerTrueAndDateBeforeAndCompletedIsTrue(sixMonthsAgo);
//            model.addAttribute("inactiveCustomers", inactiveCustomers);
//        }
//
//        return "inactiveCustomers";
//    }
}

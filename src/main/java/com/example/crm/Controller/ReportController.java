package com.example.crm.Controller;

import com.example.crm.Model.Customer;
import com.example.crm.Model.Interaction;
import com.example.crm.Repository.CustomerRepository;
import com.example.crm.Repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/report")
    public String getSummaryReport(Model model){
        List<Interaction> interactions = interactionRepository.findAll();
        List<Customer> actualCustomers = customerRepository.findByIsCustomer(true);
        int numberOfCustomers = actualCustomers.size();
        int numberOfInteractions = interactions.size();

        model.addAttribute("numberOfCustomers", numberOfCustomers);
        model.addAttribute("numberOfInteractions", numberOfInteractions);
        return "report";
    }
}

package com.example.crm.Controller;

import com.example.crm.Model.Customer;
import com.example.crm.Model.Employee;
import com.example.crm.Model.Interaction;
import com.example.crm.Repository.CustomerRepository;
import com.example.crm.Repository.EmployeeRepository;
import com.example.crm.Repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InteractionController {
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/interaction")
    public String getAllInteractions(Model model, Interaction interaction){
        List<Interaction> interactions = interactionRepository.findAll();
        model.addAttribute("interactions", interactions);
        return "interaction";
    }
    @PostMapping("/interaction")
    public String createInteraction(@RequestParam String customerEmail,
                                    @RequestParam String employeeUsername,
                                    Model model, @ModelAttribute Interaction interaction) {
        Customer customer = customerRepository.findByEmail(customerEmail);
        Employee employee = employeeRepository.findByUsername(employeeUsername);
        if(customer == null || employee == null){
            model.addAttribute("error", "Employee or Customer do not exist.");
            return "interaction";
        }
        interaction.setCustomer(customer);
        interaction.setEmployee(employee);

        interactionRepository.save(interaction);
        List<Interaction> interactions = interactionRepository.findAll();
        model.addAttribute("interactions", interactions);
        return "redirect:/interaction";
    }
}

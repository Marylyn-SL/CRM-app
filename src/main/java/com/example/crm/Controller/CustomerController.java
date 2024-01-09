package com.example.crm.Controller;

import com.example.crm.Model.Customer;
import com.example.crm.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public String getCustomers(Model model, Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @PostMapping("/customer")
    public String addCustomer(Model model, @ModelAttribute Customer customer) {
        customerRepository.save(customer);
//        List<Customer> customers = customerRepository.findAll();
        return "redirect:/customer";
    }

    @PostMapping("/send-email-to-selection")
    public String sendEmailToSelection(@RequestParam(value = "selectedEmails", required = false) List<String> selectedEmails) {
        String subject = "Check up!";
        String text = "Good morning, this message is intended to collect reviews regarding our product/service. Kindly reply directly to this email." +
                "If you're not already a customer, you can ask for more details.";
        if(selectedEmails != null){
            selectedEmails.forEach(str -> sendMessage(str, subject, text));
        }
        return "customer";
    }

    private void sendMessage(String email, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("marylynslim@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

package com.example.crm.Controller;

import com.example.crm.Model.Interaction;
import com.example.crm.Service.MessageService;
import com.example.crm.Repository.InteractionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@Controller
public class InteractionController {
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private MessageService messageService;

    @GetMapping("/interaction")
    public String getAllInteractions(Model model, Interaction interaction){
        List<Interaction> interactions = interactionRepository.findAll();
        model.addAttribute("interactions", interactions);
        return "interaction";
    }

    @PostMapping("/interaction")
    public String createInteraction(Model model, @ModelAttribute Interaction interaction) {
        interactionRepository.save(interaction);
        List<Interaction> interactions = interactionRepository.findAll();
        model.addAttribute("interactions", interactions);
        return "interaction";
    }

//    @PostMapping("/send-messages")
//    public String sendMessagesToSelectedCustomers(@RequestParam List<Long> customerIds,
//                                                 @RequestParam String message) {
//        messageService.sendMessagesToCustomers(customerIds, message);
//
//        return "redirect:/interaction";
//    }
}

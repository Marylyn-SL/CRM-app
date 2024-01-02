package com.example.crm.Controller;

import com.example.crm.Model.Interaction;
import com.example.crm.Repository.InteractionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/api")
public class InteractionController {
    @Autowired
    private InteractionRepository interactionRepository;

    @GetMapping("/interaction")
    public String getAllInteractions(Model model){
        List<Interaction> interactions = interactionRepository.findAll();
        model.addAttribute("interaction", interactions);
        return "interaction";
    }

    @PostMapping("/interaction")
    public String createInteraction(@ModelAttribute Interaction interaction, Model model){
        model.addAttribute("interaction", interaction);
        interactionRepository.save(interaction);
        return "result";
    }
}

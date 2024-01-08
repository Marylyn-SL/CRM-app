package com.example.crm.Controller;

import com.example.crm.Model.Interaction;
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
}

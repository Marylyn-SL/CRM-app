package com.example.crm.Controller;

import com.example.crm.Model.Interaction;
import com.example.crm.Repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InteractionController {
    @Autowired
    private InteractionRepository interactionRepository;

    @GetMapping("/interactions")
    public List<Interaction> getAllInteractions(){
        return interactionRepository.findAll();
    }

    @PostMapping("/interactions")
    public Interaction createInteraction(@RequestBody Interaction interaction){
        return interactionRepository.save(new Interaction(interaction.getReason()));
    }
}

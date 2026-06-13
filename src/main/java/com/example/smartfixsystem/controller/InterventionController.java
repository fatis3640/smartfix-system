package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Demande;
import com.example.smartfixsystem.entity.Intervention;
import com.example.smartfixsystem.service.DemandeService;
import com.example.smartfixsystem.service.InterventionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/interventions")
public class InterventionController {

    private final InterventionService service;
    private final DemandeService demandeService;

    public InterventionController(
            InterventionService service,
            DemandeService demandeService) {

        this.service = service;
        this.demandeService = demandeService;
    }

    @GetMapping
    public String list(Model model) {

        model.addAttribute("interventions", service.getAll());

        return "interventions";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute("intervention", new Intervention());

        model.addAttribute(
                "demandes",
                demandeService.getAll());

        return "intervention-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam(required = false) Long id,
            @RequestParam String details,
            @RequestParam String date,
            @RequestParam Long demandeId) throws Exception {

        Intervention intervention;

        if (id != null) {

            intervention = service.getAll()
                    .stream()
                    .filter(i -> i.getId().equals(id))
                    .findFirst()
                    .orElse(new Intervention());

        } else {

            intervention = new Intervention();
        }

        intervention.setDetails(details);

        intervention.setDate(
                new SimpleDateFormat("yyyy-MM-dd")
                        .parse(date));

        Demande demande =
                demandeService.getAll()
                        .stream()
                        .filter(d -> d.getId().equals(demandeId))
                        .findFirst()
                        .orElse(null);

        intervention.setDemande(demande);

        service.save(intervention);

        return "redirect:/interventions";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        Intervention intervention =
                service.getAll()
                        .stream()
                        .filter(i -> i.getId().equals(id))
                        .findFirst()
                        .orElse(null);

        model.addAttribute(
                "intervention",
                intervention);

        model.addAttribute(
                "demandes",
                demandeService.getAll());

        return "intervention-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/interventions";
    }
}
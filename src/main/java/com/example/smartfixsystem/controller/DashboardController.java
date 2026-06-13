package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.service.AppareilService;
import com.example.smartfixsystem.service.ClientService;
import com.example.smartfixsystem.service.DemandeService;
import com.example.smartfixsystem.service.InterventionService;
import com.example.smartfixsystem.service.TechnicienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final ClientService clientService;
    private final AppareilService appareilService;
    private final TechnicienService technicienService;
    private final DemandeService demandeService;
    private final InterventionService interventionService;

    public DashboardController(
            ClientService clientService,
            AppareilService appareilService,
            TechnicienService technicienService,
            DemandeService demandeService,
            InterventionService interventionService) {

        this.clientService = clientService;
        this.appareilService = appareilService;
        this.technicienService = technicienService;
        this.demandeService = demandeService;
        this.interventionService = interventionService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("clientsCount", clientService.getAll().size());
        model.addAttribute("appareilsCount", appareilService.getAll().size());
        model.addAttribute("techniciensCount", technicienService.getAll().size());
        model.addAttribute("demandesCount", demandeService.getAll().size());
        model.addAttribute("interventionsCount", interventionService.getAll().size());

        return "dashboard";
    }
}

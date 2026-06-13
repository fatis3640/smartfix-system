package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Appareil;
import com.example.smartfixsystem.entity.Demande;
import com.example.smartfixsystem.entity.Status;
import com.example.smartfixsystem.entity.Technicien;

import com.example.smartfixsystem.service.AppareilService;
import com.example.smartfixsystem.service.DemandeService;
import com.example.smartfixsystem.service.TechnicienService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService service;
    private final TechnicienService technicienService;
    private final AppareilService appareilService;

    public DemandeController(
            DemandeService service,
            TechnicienService technicienService,
            AppareilService appareilService) {

        this.service = service;
        this.technicienService = technicienService;
        this.appareilService = appareilService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("demandes", service.getAll());
        return "demandes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Demande d = service.getAll()
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("demande", d);
        model.addAttribute("techniciens", technicienService.getAll());
        model.addAttribute("appareils", appareilService.getAll());
        model.addAttribute("statuses", Status.values());

        return "edit-demande";
    }

    @GetMapping("/add")
    public String showForm(Model model) {

        model.addAttribute("demande", new Demande());
        model.addAttribute("techniciens", technicienService.getAll());
        model.addAttribute("appareils", appareilService.getAll());
        model.addAttribute("statuses", Status.values());

        return "add-demande";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/demandes";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String description,
                       @RequestParam String status,
                       @RequestParam(required = false) Long technicienId,
                       @RequestParam(required = false) Long appareilId) {

        Demande d = (id != null)
                ? service.getAll()
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(new Demande())
                : new Demande();

        d.setDescription(description);
        d.setStatus(Status.valueOf(status));

        if (technicienId != null) {
            d.setTechnicien(technicienService.getById(technicienId));
        }

        if (appareilId != null) {
            d.setAppareil(appareilService.getById(appareilId));
        }

        service.save(d);

        return "redirect:/demandes";
    }

    @GetMapping("/search")
    public String search(@RequestParam String status, Model model) {

        List<Demande> list = service.getByStatus(Status.valueOf(status));

        model.addAttribute("demandes", list);

        return "demandes";
    }
}
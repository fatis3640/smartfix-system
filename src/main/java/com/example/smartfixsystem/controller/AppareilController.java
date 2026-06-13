package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Appareil;
import com.example.smartfixsystem.service.AppareilService;
import com.example.smartfixsystem.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appareils")
public class AppareilController {

    private final AppareilService appareilService;
    private final ClientService clientService;

    public AppareilController(AppareilService appareilService,
                              ClientService clientService) {
        this.appareilService = appareilService;
        this.clientService = clientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("appareils", appareilService.getAll());
        return "appareils";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute("appareil", new Appareil());
        model.addAttribute("clients", clientService.getAll());

        return "appareil-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Appareil appareil) {

        appareilService.save(appareil);

        return "redirect:/appareils";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute(
                "appareil",
                appareilService.getById(id));

        model.addAttribute(
                "clients",
                clientService.getAll());

        return "appareil-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        appareilService.delete(id);

        return "redirect:/appareils";
    }
}
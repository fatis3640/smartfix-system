package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Client;
import com.example.smartfixsystem.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clients", service.getAll());
        return "clients";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("client", new Client());
        return "client-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Client client) {
        service.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Client client = service.getById(id);

        model.addAttribute("client", client);

        return "client-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/clients";
    }
}
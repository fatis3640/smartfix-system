package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.service.TechnicienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/techniciens")
public class TechnicienController {

    private final TechnicienService service;

    public TechnicienController(TechnicienService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("techniciens", service.getAll());
        return "techniciens";
    }
}
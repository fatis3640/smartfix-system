package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.service.AppareilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appareils")
public class AppareilController {

    private final AppareilService service;

    public AppareilController(AppareilService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("appareils", service.getAll());
        return "appareils";
    }
}
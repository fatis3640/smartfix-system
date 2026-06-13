package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Technicien;
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

    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute("technicien", new Technicien());

        return "technicien-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Technicien technicien) {

        service.save(technicien);

        return "redirect:/techniciens";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Technicien technicien =
                service.getAll()
                        .stream()
                        .filter(t -> t.getId().equals(id))
                        .findFirst()
                        .orElse(null);

        model.addAttribute("technicien", technicien);

        return "technicien-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/techniciens";
    }
}
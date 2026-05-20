package com.example.smartfixsystem.controller;

import com.example.smartfixsystem.entity.Appareil;
import com.example.smartfixsystem.entity.Demande;
import com.example.smartfixsystem.entity.Status;
import com.example.smartfixsystem.entity.Technicien;
import com.example.smartfixsystem.service.DemandeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService service;

    public DemandeController(DemandeService service) {
        this.service = service;
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

        return "edit-demande";
    }
    // عرض الفورم
    @GetMapping("/add")
    public String showForm() {
        return "add-demande";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/demandes";
    }

    // حفظ البيانات
    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String description,
                       @RequestParam String status,
                       @RequestParam(required = false) Long technicienId,
                       @RequestParam(required = false) Long appareilId) {

        Demande d = (id != null) ?
                service.getAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(new Demande())
                : new Demande();

        d.setDescription(description);
        d.setStatus(Status.valueOf(status));

        if (technicienId != null) {
            Technicien t = new Technicien();
            t.setId(technicienId);
            d.setTechnicien(t);
        }

        if (appareilId != null) {
            Appareil a = new Appareil();
            a.setId(appareilId);
            d.setAppareil(a);
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
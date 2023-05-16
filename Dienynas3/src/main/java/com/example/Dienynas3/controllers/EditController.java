package com.example.Dienynas3.controllers;
import com.example.Dienynas3.models.Mokinys;
import com.example.Dienynas3.rep.MokinysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EditController {
    @Autowired
    private MokinysRepository mokinysRepository;

    @GetMapping("/home/{id}/edit")
    public String MokiniaiEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!mokinysRepository.existsById(id)) {
            return "home";

        }
        Optional<Mokinys> mokiniai = mokinysRepository.findById(id);
        ArrayList<Mokinys> res = new ArrayList<>();
        mokiniai.ifPresent(res::add);
        model.addAttribute("Mokinys", res);

        return "koreguoti";
    }

    @PostMapping("/home/{id}/edit")
    public String MokiniaiUpdate(@PathVariable(value = "id") Long id, @RequestParam String vardas, @RequestParam String pavarde,@RequestParam String dalykas,@RequestParam int ivertinimas,@RequestParam String pastabos,@RequestParam String vartotojas, Model model) {
        Mokinys mokiniai = mokinysRepository.findById(id).orElseThrow();
        mokiniai.setVardas(vardas);
        mokiniai.setPavarde(pavarde);
        mokiniai.setDalykas(dalykas);
        mokiniai.setIvertinimas(ivertinimas);
        mokiniai.setPastabos(pastabos);
        mokiniai.setVartotojas(vartotojas);
        mokinysRepository.save(mokiniai);

        return "/home";

    }
}

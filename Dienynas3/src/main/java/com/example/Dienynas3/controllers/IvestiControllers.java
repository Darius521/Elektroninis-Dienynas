package com.example.Dienynas3.controllers;





import com.example.Dienynas3.models.Mokinys;
import com.example.Dienynas3.rep.MokinysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IvestiControllers {
    @Autowired
    private MokinysRepository mokiniaiRepository;
    @GetMapping("ivesti")
    public String ivesti(Model model){

        return "ivesti";
    }
    @PostMapping("/ivesti")
    public String ivestiAdd(@RequestParam String vardas, @RequestParam String pavarde,@RequestParam String dalykas,@RequestParam int ivertinimas, @RequestParam String pastabos, @RequestParam String vartotojas, Model model) {
        Mokinys mokiniai=new Mokinys(vardas,pavarde,dalykas,ivertinimas,pastabos,vartotojas);
        mokiniaiRepository.save(mokiniai);

        return "/home";

    }
}

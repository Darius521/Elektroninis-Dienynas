package com.example.Dienynas3.controllers;





import com.example.Dienynas3.models.Mokinys;
import com.example.Dienynas3.rep.MokinysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ApieController {
    @Autowired
    private MokinysRepository mokinysRepository;
    @GetMapping( "/home/{id}")
    public String apie(@PathVariable(value = "id") Long id, Model model) {
        if (!mokinysRepository.existsById(id)){
            return "home";

        }
        Optional <Mokinys> mokiniai = mokinysRepository.findById(id);
        ArrayList <Mokinys> res = new ArrayList<>();
        mokiniai.ifPresent(res :: add);
        model.addAttribute("Mokinys",res);

        return "apie";
    }
}


package com.example.Dienynas3.controllers;




import com.example.Dienynas3.models.Mokinys;
import com.example.Dienynas3.rep.MokinysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteControllers {
    @Autowired
    private MokinysRepository mokinysRepository;

    @PostMapping("/home/{id}/remove")
    public String MokiniaiDelete(@PathVariable(value = "id") Long id, Model model) {
        Mokinys mokiniai = mokinysRepository.findById(id).orElseThrow();
        mokinysRepository.delete(mokiniai);

        return "/home";
    }
}


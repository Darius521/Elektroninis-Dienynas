package com.example.Dienynas3.controllers;

import com.example.Dienynas3.models.Mokinys;
import com.example.Dienynas3.rep.MokinysRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class MokiniaiController {
    @Autowired
    private MokinysRepository mokinysRepository;
    @GetMapping("/")
    public  String home(Model model) {
        Iterable<Mokinys> mokinys= mokinysRepository.findAll();
        model.addAttribute( "Mokinys",mokinys);
        return "/home";
    }

}

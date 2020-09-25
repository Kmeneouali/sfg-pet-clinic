package com.km.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets","/vets/index","vets/index.html"})
    public String listVets(Model model){
//        model.addAttribute("listVets");
        return "vets/index";
    }
}
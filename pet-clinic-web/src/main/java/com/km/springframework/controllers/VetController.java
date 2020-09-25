package com.km.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/verts")
@Controller
public class VetController {

    @RequestMapping({"/","/index","/index.html"})
    public String listVets(Model model){
//        model.addAttribute("listVets");
        return "vets/index";
    }
}

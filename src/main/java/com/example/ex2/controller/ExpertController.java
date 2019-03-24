package com.example.ex2.controller;

import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ExpertToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expertList")
@PreAuthorize("hasAuthority('MOD2')")
public class ExpertController {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ExpertToolRepo expertToolRepo;

    @GetMapping
    public String ExpertList(Model model){

        model.addAttribute("experts", expertRepo.findAll());
        return "expertList";
    }

//    @GetMapping("/expert/new/")
//    public String newExpert(Model model){
//    }

}

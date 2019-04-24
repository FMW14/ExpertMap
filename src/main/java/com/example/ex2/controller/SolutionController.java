package com.example.ex2.controller;

import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solution")
@PreAuthorize("hasAuthority('USER')")
public class SolutionController {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;

    @GetMapping
    public String solution(Model model){
        model.addAttribute("problems", problemRepo.findAll());
        model.addAttribute("tasks", taskRepo.findAll());
        model.addAttribute("tools", toolRepo.findAll());


        return "solution";
    }
}

package com.example.ex2.controller;

import com.example.ex2.domain.Problem;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
//        model.addAttribute("tasks", taskRepo.findAll());
//        model.addAttribute("tools", toolRepo.findAll());


        return "solution";
    }

    @GetMapping("/step2")
    public String stepTwo(Model model){
        model.addAttribute("tools", toolRepo.findAll());


        return "solution";
    }

//    @PostMapping("/solution")
//    public String submitStepOne(
//            @RequestParam(value = "problemList") Problem problem,
//            @RequestParam Map<String, String> form) {
//        System.out.println("PROBLEM ID" + problem.getId());
////        return new ModelAndView("problem", "command", problem);
//
//    }


}

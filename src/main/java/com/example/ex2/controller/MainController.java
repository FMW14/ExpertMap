package com.example.ex2.controller;

import com.example.ex2.domain.Problem;
import com.example.ex2.repos.ProblemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProblemRepo problemRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Problem> problems = problemRepo.findAll();
        model.put("problems", problems);
        return "main";
    }

    @GetMapping("problemslist")
    public String problemslist(Map<String, Object> model) {
        Iterable<Problem> problems = problemRepo.findAll();
        model.put("problems", problems);
        return "problemslist";
    }

    @GetMapping("/login")
    public String registration(){
        return "login";
    }


//    @PostMapping("addproblem")
    @PostMapping("/problemslist")
    public String add(@RequestParam String name, Map<String, Object> model){
        Problem problem = new Problem(name);
        problemRepo.save(problem);

        Iterable<Problem> problems = problemRepo.findAll();
        model.put("problems", problems);
        //return "problemslist";
        return "redirect:/";
        //return "addproblem";
    }

}

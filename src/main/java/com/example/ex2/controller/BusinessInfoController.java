package com.example.ex2.controller;


import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/businessInfo")
@PreAuthorize("hasAuthority('MOD1')")
public class BusinessInfoController {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("problems", problemRepo.findAll());
        model.addAttribute("tasks", taskRepo.findAll());
        return "businessInfo";
    }

    @GetMapping("/problem/{problem}")
    public String problemEditForm(@PathVariable Problem problem, Model model){
        model.addAttribute("problem", problem);
        model.addAttribute("probTasks", taskRepo.findByProblems(problem));
//        model.addAttribute("probTasks", taskRepo.findAll());
        return "problemEdit";
    }

    @GetMapping("/task/{task}")
    public String taskEditForm(@PathVariable Task task, Model model){
        model.addAttribute("task", task);
        model.addAttribute("taskTools", toolRepo.findByTasks(task));
//        model.addAttribute("probTasks", taskRepo.findAll());
        return "taskEdit";
    }

}

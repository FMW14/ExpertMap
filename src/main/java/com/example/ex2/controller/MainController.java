package com.example.ex2.controller;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
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
    @Autowired
    private TaskRepo taskRepo;

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

    @GetMapping("tasks")
    public String tasks(Map<String, Object> model) {
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/login")
    public String registration(){
        return "login";
    }


//    @PostMapping("addproblem")
    @PostMapping("addProblem")
    public String addProblem(@RequestParam String name, Map<String, Object> model){
        Problem problem = new Problem(name);
        problemRepo.save(problem);


        Iterable<Problem> problems = problemRepo.findAll();
        model.put("problems", problems);
        return "redirect:/problemslist";
        //return "redirect:/";
        //return "addproblem";
    }

    @PostMapping("addTask")
    public String addTask(@RequestParam String name, Map<String, Object> model){
        Task task = new Task(name);
        taskRepo.save(task);
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "redirect:/tasks";

    }

}

package com.example.ex2.controller;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;

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

    @GetMapping("list")
    public String problemslist(Map<String, Object> model) {
        Iterable<Problem> problems = problemRepo.findAll();
        model.put("problems", problems);
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        Iterable<Tool> tools = toolRepo.findAll();
        model.put("tools", tools);
        return "list";
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
        return "redirect:/list";
        //return "redirect:/";
        //return "addproblem";
    }

    @PostMapping("addTask")
    public String addTask(@RequestParam String name, Map<String, Object> model){
        Task task = new Task(name);
        taskRepo.save(task);
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "redirect:/list";
    }

    @PostMapping("addProbTask")
    public String addProbTask(
                              @RequestParam(value = "probId", required = true) Problem newProblem,
                              @RequestParam(value = "taskId", required = true) Task newTask,
                              Map<String, Object> model
    ){

        Task task = taskRepo.findById(newTask.getId()).orElse(null);
        List<Task> tasks = newProblem.getTasks();
        tasks.add(task);

        newProblem.setTasks(tasks);

        problemRepo.save(newProblem);

        return "redirect:/list";
    }

    @PostMapping("addTaskTool")
    public String addTaskTool(
            @RequestParam(value = "taskId", required = true) Task newTask,
            @RequestParam(value = "toolId", required = true) Tool newTool,
            Map<String, Object> model
    ){

        Tool tool = toolRepo.findById(newTool.getId()).orElse(null);
        List<Tool> tools = newTask.getTools();
        tools.add(tool);

        newTask.setTools(tools);

        taskRepo.save(newTask);

        return "redirect:/list";
    }

}

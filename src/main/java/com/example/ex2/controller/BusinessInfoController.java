package com.example.ex2.controller;


import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//    private List<Task> tasks =

    @GetMapping
    public String businessInfo(Model model){
//        Problem p = new Problem();
        model.addAttribute("problems", problemRepo.findAll());
        model.addAttribute("tasks", taskRepo.findAll());
//        model.addAttribute("newProblem", p);
        return "businessInfo";
    }

    @GetMapping("/problem/edit/{problem}")
    public String problemEditForm(Model model,
                                  @PathVariable Problem problem
                                  ){
//        model.addAttribute("action", action);
        model.addAttribute("problem", problem);
        model.addAttribute("probTasks", taskRepo.findAll());
        return "problemEdit";
    }

    @GetMapping("/problem/new/")
    public String newProblem(Model model){
//        String action = "new";
//        model.addAttribute("action", action);
        Problem newProblem = new Problem();
        model.addAttribute("problem", newProblem);
        model.addAttribute("probTasks", taskRepo.findAll());
//        return "newProblem";
        return "problemEdit";
    }

    @GetMapping("/task/{task}")
    public String taskEditForm(@PathVariable Task task, Model model){
        model.addAttribute("task", task);
//        model.addAttribute("taskTools", toolRepo.findByTasks(task));
        model.addAttribute("taskTools", toolRepo.findAll());
        return "taskEdit";
    }



//    @PostMapping("/problem/edit")
//    public String saveProblem(
//                              @RequestParam(value = "problemName", required = false) String problemName,
//                              @RequestParam(value = "problemId", required = false) Problem newProblem,
//                              @RequestParam Map<String, String> form){
//
//        newProblem.setName(problemName);
//        List<Task> tasks = new ArrayList<>();
//
////        Set<String> t = new HashSet<>();
//
//        for (Map.Entry entry: form.entrySet()) {
//            String key = entry.getKey().toString();
//            String value = entry.getValue().toString();
////            System.out.println(key + " " + value);
//            if (value.equals("on")){
////                t.add(key);
//                List<Task> tt = taskRepo.findById(Integer.parseInt(key));
//                tasks.add(tt.get(0));
//            }
////действия с ключом и значением
//        }
//
////        form.forEach((k, v) -> System.out.println(k + " " + v));
//
////                if(newProblem.getTasks() != null){
////            newProblem.getTasks().clear();
////        }
//        newProblem.getTasks().clear();
//
//
//
////        for (String key : t){
////
////            List<Task> tt = taskRepo.findById(Integer.parseInt(key));
//////            System.out.println(tt.size());
////            tasks.add(tt.get(0));
////
////        }
//
////            System.out.println(tasks.toString());
//
//        newProblem.setTasks(tasks);
//        problemRepo.save(newProblem);
////        model.addAttribute("message", "Problem edited");
//
//        return "redirect:/businessInfo";
//        //return "redirect:/";
//        //return "addproblem";
//    }

    @PostMapping("/problem/edit")
    public String saveNewProblem(
            @RequestParam(value = "problemName") String problemName,
            @RequestParam Map<String, String> form){

        Problem newProblem = new Problem(problemName);
        newProblem.setName(problemName);
        List<Task> tasks = new ArrayList<>();

        for (Map.Entry entry: form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (value.equals("on")) {
                List<Task> tt = taskRepo.findById(Integer.parseInt(key));
                tasks.add(tt.get(0));
            }
        }
        if(newProblem.getTasks() != null){
            newProblem.getTasks().clear();
        }



        newProblem.setTasks(tasks);
        problemRepo.save(newProblem);

        return "redirect:/businessInfo";
        //return "redirect:/";
        //return "addproblem";
    }

    @PostMapping("/task/")
    public String saveTask(@RequestParam(value = "taskName") String taskName,
                           @RequestParam(value = "taskId") Task newTask,
                           @RequestParam Map<String, String> form){

        newTask.setName(taskName);
        List<Tool> tools = new ArrayList<>();
        for (Map.Entry entry: form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println(key + " " + value);
            if (value.equals("on")){
                List<Tool> tt = toolRepo.findById(Integer.parseInt(key));
                tools.add(tt.get(0));
            }
        }

        if(newTask.getTools() != null) {
            newTask.getTools().clear();
        }
        newTask.setTools(tools);
        taskRepo.save(newTask);
//        model.addAttribute("message", "Task edited");

        return "redirect:/businessInfo";
    }

}

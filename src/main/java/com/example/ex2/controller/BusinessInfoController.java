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
        model.addAttribute("tools", toolRepo.findAll());
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

    @GetMapping("/task/edit/{task}")
    public String taskEditForm(Model model,
                               @PathVariable Task task){
        model.addAttribute("task", task);
//        model.addAttribute("taskTools", toolRepo.findByTasks(task));
        model.addAttribute("taskTools", toolRepo.findAll());
        return "taskEdit";
    }

    @GetMapping("/tool/edit/{tool}")
    public String toolEditForm(Model model,
                               @PathVariable Tool tool){
        model.addAttribute("tool", tool);
        return "toolEdit";
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

    @GetMapping("/task/new/")
    public String newTask(Model model){
        Task newTask = new Task();
        model.addAttribute("task", newTask);
        model.addAttribute("taskTools", toolRepo.findAll());
        return "taskEdit";
    }

    @GetMapping("/tool/new/")
    public String newTool(Model model){
        Tool newTool = new Tool();
        model.addAttribute("tool", newTool);
        return "toolEdit";
    }

    @PostMapping("/problem/edit")
    public String saveNewProblem(
            @RequestParam(value = "problemName") String problemName,
            @RequestParam(value = "problemId", required = false) String idp,
            @RequestParam Map<String, String> form){


        Problem newProblem = new Problem(problemName);


        if (idp != null && idp != ""){
            List<Problem> byId = problemRepo.findById(Integer.parseInt(idp));
            newProblem.setId(byId.get(0).getId());
        }

//        if (problemName != null && problemName != ""){
//            List<Problem> problems = problemRepo.findByName(problemName);
//            if(problems.size() == 0){
//                newProblem.setName(problemName);
//            }
//            else {
//                return "redirect:/businessInfo";
//            }
//        }
//        else{
////            System.out.println("null name");
//            return "redirect:/businessInfo";
//        }

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

    @PostMapping("/task/edit")
    public String saveNewTask(
            @RequestParam(value = "taskName") String taskName,
            @RequestParam(value = "taskId", required = false) String idt,
            @RequestParam Map<String, String> form){

        Task newTask = new Task(taskName);
//        Task newTask = new Task();

        if (idt != null && idt != ""){
            List<Task> byId = taskRepo.findById(Integer.parseInt(idt));
            newTask.setId(byId.get(0).getId());
        }

//        if (taskName != null && taskName != ""){
//            List<Task> tasks = taskRepo.findByName(taskName);
//            if(tasks.size() == 0 || tasks.get(0).getId() == Integer.parseInt(idt)){
//                newTask.setName(taskName);
//            }
//            else {
//                System.out.println(2);
//                return "redirect:/businessInfo";
//            }
//        }


        List<Tool> tools = new ArrayList<>();

        for (Map.Entry entry: form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (value.equals("on")) {
                List<Tool> tt = toolRepo.findById(Integer.parseInt(key));
                tools.add(tt.get(0));
            }
        }
        if(newTask.getTools() != null){
            newTask.getTools().clear();
        }

        newTask.setTools(tools);
        taskRepo.save(newTask);

        return "redirect:/businessInfo";
        //return "redirect:/";
        //return "addtask";
    }

    @PostMapping("/tool/edit")
    public String saveNewTool(
            @RequestParam(value = "toolName") String toolName,
            @RequestParam(value = "toolId", required = false) String idt,
            @RequestParam Map<String, String> form){

        Tool newTool = new Tool(toolName);

        if (idt != null && idt != ""){
            List<Tool> byId = toolRepo.findById(Integer.parseInt(idt));
            newTool.setId(byId.get(0).getId());
        }

//        if (toolName != null && toolName != ""){
//            List<Tool> tools = toolRepo.findByName(toolName);
//            if(tools.size() == 0){
//                newTool.setName(toolName);
//            }
//            else {
//                return "redirect:/businessInfo";
//            }
//        }

        toolRepo.save(newTool);
        return "redirect:/businessInfo";
    }


    @GetMapping("/problem/delete/{problem}")
    public String deleteProblem(@PathVariable Problem problem
    ){
        problemRepo.delete(problem);

        return "redirect:/businessInfo";
    }

    @GetMapping("/task/delete/{task}")
    public String deleteTask(@PathVariable Task task
    ){
        taskRepo.delete(task);

        return "redirect:/businessInfo";
    }

    @GetMapping("/tool/delete/{tool}")
    public String deleteTool(@PathVariable Tool tool
    ){
        toolRepo.delete(tool);

        return "redirect:/businessInfo";
    }

    //TODO uniq name check

}

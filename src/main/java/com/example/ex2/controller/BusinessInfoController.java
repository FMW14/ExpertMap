package com.example.ex2.controller;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.CountryRepo;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import com.example.ex2.service.ProblemService;
import com.example.ex2.service.TaskService;
import com.example.ex2.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/businessInfo")
@PreAuthorize("hasAuthority('USER')")
public class BusinessInfoController {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ToolService toolService;
    @Autowired
    private ProblemService problemService;

    @GetMapping
    public String businessInfo(Model model){
        model.addAttribute("problems", problemRepo.findAllByOrderByNameAsc());
        model.addAttribute("tasks", taskRepo.findAllByOrderByNameAsc());
        model.addAttribute("tools", toolRepo.findAllByOrderByNameAsc());
        return "businessInfo";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/problem/edit/{problem}")
    public String problemEditForm(Model model,
                                  @PathVariable Problem problem){
        model.addAttribute("problem", problem);
        model.addAttribute("probTasks", taskRepo.findAllByOrderByNameAsc());
        return "problemEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/problem/edit/")
    public String problemEditForm2(Model model){
        Problem problem = new Problem();
        model.addAttribute("problem", problem);
        model.addAttribute("probTasks", taskRepo.findAllByOrderByNameAsc());
        return "problemEdit";
    }


    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/task/edit/{task}")
    public String taskEditForm(Model model,
                               @PathVariable Task task){
        model.addAttribute("task", task);
        model.addAttribute("taskTools", toolRepo.findAllByOrderByNameAsc());
        return "taskEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/task/edit/")
    public String taskEditForm2(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("taskTools", toolRepo.findAllByOrderByNameAsc());
        return "taskEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/tool/edit/{tool}")
    public String toolEditForm(Model model,
                               @PathVariable Tool tool){
        model.addAttribute("tool", tool);
        return "toolEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/tool/edit/")
    public String toolEditForm2(Model model){
        Tool tool = new Tool();
        model.addAttribute("tool", tool);
        return "toolEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping("/problem/post")
    public String saveProblem(
            @Valid Problem problem,
            BindingResult bindingResult,
            Model model,
            @RequestParam(value = "name") String problemName,
            @RequestParam(value = "Id", required = false) String idp,
            @RequestParam(value = "type", required = false) String problemType,
            @RequestParam Map<String, String> form){

        problemService.setTasksAndType(problem, problemType, form);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("problem", problem);
            model.addAttribute("probTasks", taskRepo.findAll());
            model.addAttribute("countries", countryRepo.findAllByOrderByTitleruAsc());
        } else {
            problemService.saveTask(problem, problemName, idp);
            return "redirect:/businessInfo";
        }
        return "problemEdit";

    }



    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping("/task/post")
    public String saveTask(
            @Valid Task task,
            BindingResult bindingResult,
            Model model,
            @RequestParam(value = "name") String taskName,
            @RequestParam(value = "Id", required = false) String idt,
            @RequestParam Map<String, String> form){

        taskService.setTools(task, form);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("task", task);
            model.addAttribute("taskTools", toolRepo.findAll());

//            return "/businessInfo/task/edit/" + idt;
        } else {
            taskService.saveTask(task, taskName, idt);
            return "redirect:/businessInfo";
        }
        return "taskEdit";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping("/tool/post")
    public String saveTool(
            @Valid Tool tool,
            BindingResult bindingResult,
            Model model,
            @RequestParam(value = "name") String toolName,
            @RequestParam(value = "Id", required = false) String idt) {

        tool.setName(toolName);
//        Tool newTool = new Tool(toolName);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("tool", tool);
        } else {
            toolService.saveTool(tool, toolName, idt);
//            model.addAttribute("tool", null);
            return "redirect:/businessInfo";
        }
        return "toolEdit";
    }


    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/problem/delete/{problem}")
    public String deleteProblem(@PathVariable Problem problem
    ){
        problemRepo.delete(problem);

        return "redirect:/businessInfo";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/task/delete/{task}")
    public String deleteTask(@PathVariable Task task
    ){
        taskRepo.delete(task);

        return "redirect:/businessInfo";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @GetMapping("/tool/delete/{tool}")
    public String deleteTool(@PathVariable Tool tool
    ){
        toolRepo.delete(tool);

        return "redirect:/businessInfo";
    }
}

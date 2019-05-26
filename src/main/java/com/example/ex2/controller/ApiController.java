package com.example.ex2.controller;

import com.example.ex2.domain.*;
import com.example.ex2.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.*;

@Controller
@RequestMapping("/api")
@PreAuthorize("hasAuthority('USER')")
public class ApiController {
@Autowired
private ToolRepo toolRepo;
//@Autowired
//private CountryRepo countryRepo;
//@Autowired
//private CityRepo cityRepo;
@Autowired
private TaskRepo taskRepo;
@Autowired
private ProblemRepo problemRepo;

    @GetMapping("/rest")
    public String rest(Model model){

        return "rest";
    }

    @RequestMapping(value = "/getc", method = RequestMethod.GET)
    @ResponseBody
    public String getC(@RequestParam String val) {
//        System.out.println("ping");
//        Country c = countryRepo.findById(Long.parseLong(val)).get();
//        List<Country> cl = countryRepo.findById(Long.parseLong(val));
        List<Tool> t = toolRepo.findById(Integer.parseInt(val));
        return t.get(0).getName();
    }

//    @RequestMapping(value = "/get_tasks", method = RequestMethod.GET)
//    @ResponseBody
//    public String getTasks(@RequestParam String val) {
//        System.out.println("ping2");
//        Problem problem = problemRepo.findById(Integer.parseInt(val)).get(0);
//        List<Task> t = taskRepo.findByProblems(problem);
////                findById(Integer.parseInt(val));
//        return t.toString();
////        return val;
//    }

    @RequestMapping(value = "/get_tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getTasks(@RequestParam String val) {
        Problem problem = problemRepo.findById(Integer.parseInt(val)).get(0);
        List<Task> t = taskRepo.findByProblems(problem);
        return t;
    }

    @RequestMapping(value = "/get_tools", method = RequestMethod.GET, consumes="application/json")
    @ResponseBody
    public List<Tool> getTools(@RequestParam(value="selected[]") String[] selected) {
//        System.out.println("got it");
        Set<Tool> s = new LinkedHashSet<>();

        for (int i = 0; i < selected.length; i++) {     //получение списка инструментов согласно выбранным задачам
            Task task = taskRepo.findById(Integer.parseInt(selected[i])).get(0);
            List<Tool> gotByTask = toolRepo.findByTasks(task);

            for (Tool tl : gotByTask){
                s.add(tl);
            }
        }

        List<Tool> t = new ArrayList<>(s);
        return t;
    }

}

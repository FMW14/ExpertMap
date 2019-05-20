package com.example.ex2.controller;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.dto.ExpertDto;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import com.example.ex2.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/solution")
@PreAuthorize("hasAuthority('USER')")
public class SolutionController {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private SolutionService solutionService;

    @GetMapping
    public String solution(Model model){
        model.addAttribute("problems", problemRepo.findAllByOrderByNameAsc());
//        model.addAttribute("tasks", taskRepo.findAll());
//        model.addAttribute("tools", toolRepo.findAll());


        return "solution";
    }

    @GetMapping("/result")
    public String stepTwo(@RequestParam Map<String, String> form,
            Model model){
//        model.addAttribute("problems", problemRepo.findAllByOrderByNameAsc());

        Set<ToolRate> parsedForm = solutionService.parseSolutionForm(form);
//        Set<ExpertToolDto> response = solutionService.getExpertsByTools(parsedForm);
        Set<ExpertDto> experts = solutionService.getExpertsByTools(parsedForm);

//        Task t = taskRepo.findById(1).get(0);
//        Expert ee = expertRepo.findById(2l).orElse(new Expert());

//        Set<Expert> experts = new LinkedHashSet<>();
//        for(ExpertToolDto exd : response){
//            Expert e = expertRepo.findById(exd.getExpertId()).get();
//            experts.add(e);
//        }
        model.addAttribute("tools", parsedForm);

        model.addAttribute("experts", experts);
        model.addAttribute("toolslist", toolRepo.findAll());

        return "result";
    }


//    @PreAuthorize("hasAuthority('USER')")


}

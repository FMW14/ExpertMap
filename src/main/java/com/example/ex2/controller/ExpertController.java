package com.example.ex2.controller;

import com.example.ex2.domain.Expert;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ExpertToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expertList")
@PreAuthorize("hasAuthority('MOD2')")
public class ExpertController {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ExpertToolRepo expertToolRepo;

    @GetMapping
    public String ExpertList(Model model){

        model.addAttribute("experts", expertRepo.findAll());
        return "expertList";
    }

    @GetMapping("/expert/edit/{expert}")
    public String expertEditForm(Model model,
                               @PathVariable Expert expert){
        model.addAttribute("expert", expert);

        return "expertEdit";
    }

    @GetMapping("/expert/new/")
    public String newExpert(Model model){
        Expert newExpert = new Expert();
        model.addAttribute("expert", newExpert);
        return "expertEdit";
    }

    @GetMapping("/expert/delete/{expert}")
    public String deleteExpert(@PathVariable Expert expert
    ){
        expertRepo.delete(expert);

        return "redirect:/expertList";
    }

    @PostMapping("/expert/edit")
    public String saveExpert(
            @RequestParam(value = "expertName") String expertName,
            @RequestParam(value = "expertSurname") String expertSurname,
            @RequestParam(value = "expertPatronymic") String expertPatronymic,
            @RequestParam(value = "expertId", required = false) String id,
            @RequestParam Map<String, String> form){

        Expert newExpert = new Expert(expertName);
        newExpert.setSurname(expertSurname);
        newExpert.setPatronymic(expertPatronymic);

        if (id != null && id != ""){
            List<Expert> byId = expertRepo.findById(Integer.parseInt(id));
            newExpert.setId(byId.get(0).getId());
        }

        expertRepo.save(newExpert);
        return "redirect:/businessInfo";
    }


}

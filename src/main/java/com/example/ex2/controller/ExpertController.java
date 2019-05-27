package com.example.ex2.controller;

import com.example.ex2.domain.*;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.*;
import com.example.ex2.service.ExpertService;
import com.example.ex2.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expertList")
@PreAuthorize("hasAuthority('MOD2')")
public class ExpertController {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ExpertService expertService;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private LangRepo langRepo;

    @GetMapping
    public String ExpertList(Model model){

        model.addAttribute("experts", expertRepo.findAll());
        return "expertList";
    }

    @GetMapping("/expert/edit/{value}")
    public String expertEditForm(Model model,
                                 @PathVariable String value){

        Expert expert = expertService.findById(value);

        expertService.makeEditForm(expert, model);

        model.addAttribute("expert", expert);
        return "expertEdit";
    }

    @GetMapping("/expert/new")
    public String newExpert(Model model){
        Expert newExpert = new Expert();


        List<ToolRate> rate = expertService.getToolRateWithZeros();

        model.addAttribute("rate", rate);
        model.addAttribute("expert", newExpert);
        model.addAttribute("countries", countryRepo.findAllByOrderByTitleruAsc());
        model.addAttribute("langs", langRepo.findAllByOrderByTitleruAsc());
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
            @Valid Expert expert,
            BindingResult bindingResult,
            Model model,
//            @RequestParam(value = "Name") String expertName,
//            @RequestParam(value = "Surname") String expertSurname,
//            @RequestParam(value = "Patronymic") String expertPatronymic,
//            @RequestParam(value = "Country") Country expertCountry,
//            @RequestParam(value = "City") String expertCity,
//            @RequestParam(value = "Email") String expertEmail,
//            @RequestParam(value = "Phone") String expertPhone,
            @RequestParam(value = "online", required = false) String online,
            @RequestParam(value = "offline", required = false) String offline,
            @RequestParam(value = "Id", required = false) String id,
            @RequestParam Map<String, String> form){

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);


            expertService.setAccessType(expert, online, offline);
            expertService.parseAndSetToolRate(expert, form);
            expert.setLang(expertService.parseLangs(form));
            expertService.makeEditForm(expert, model);
            model.addAttribute("expert", expert);
        } else {
            expertService.saveExpert(expert, online, offline, id, form);
            return "redirect:/expertList";
        }
        return "expertEdit";
    }
}

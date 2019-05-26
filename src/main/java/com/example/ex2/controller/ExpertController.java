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
import java.util.ArrayList;
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
    private ToolService toolService;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private ExpertToolRepo expertToolRepo;
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

        expertService.makeEditForm(model, expert);

        model.addAttribute("expert", expert);
        model.addAttribute("countries", countryRepo.findAllByOrderByTitleruAsc());
        model.addAttribute("langs", langRepo.findAllByOrderByTitleruAsc());
        return "expertEdit";
    }

    @GetMapping("/expert/new")
    public String newExpert(Model model){
        Expert newExpert = new Expert();


        List<ToolRate> rate = expertService.getToolRate();

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
            @RequestParam(value = "Name") String expertName,
            @RequestParam(value = "Surname") String expertSurname,
            @RequestParam(value = "Patronymic") String expertPatronymic,
//            @RequestParam(value = "Country") Country expertCountry,
            @RequestParam(value = "City") String expertCity,
            @RequestParam(value = "Email") String expertEmail,
            @RequestParam(value = "Phone") String expertPhone,
            @RequestParam(value = "online", required = false) String online,
            @RequestParam(value = "offline", required = false) String offline,
            @RequestParam(value = "Id", required = false) String id,
            @RequestParam Map<String, String> form){

        Expert newExpert = new Expert(expertName);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("expert", expert);

//            ----------------------------------------------------------------------------
            List<ToolRate> rate = new ArrayList<>();
            List<ToolRate> curRate = new ArrayList<>();
//        List<Country> countries = countryRepo.findAll();


//        Ебовая конструкция для проверки количества текущих инструментов
            for(Tool t : toolRepo.findAll()){
                rate.add(new ToolRate(t.getName(), 0));
            }

            for(ExpertTool et : expert.getExpertTools()){
                curRate.add(
                        new ToolRate(
                                et.getTool().getName(), et.getRating()));
            }

            for(ToolRate tr : rate){
                for(ToolRate ctr : curRate){
                    if(tr.getToolname().equals(ctr.getToolname())){
                        tr.setRate(ctr.getRate());
                    }
                }
            }

            List<Language> languages = langRepo.findAllByOrderByTitleruAsc();
            List<Country> countries = countryRepo.findAllByOrderByTitleruAsc();
            model.addAttribute("countries", countries);
            model.addAttribute("langs", languages);
            model.addAttribute("rate", rate);

//            ----------------------------------------------------------------------------

//            model.addAttribute("taskTools", toolRepo.findAll());

//            return "/businessInfo/task/edit/" + idt;
        } else {

            newExpert.setSurname(expertSurname);
            newExpert.setPatronymic(expertPatronymic);
//            newExpert.setCountry(expertCountry);
            newExpert.setCity(expertCity);
            newExpert.setEmail(expertEmail);
            newExpert.setPhone(expertPhone);

            if (online!= null && online != ""){
                newExpert.setOnline(true);
            }
            else {
                newExpert.setOnline(false);
            }
            if (offline!= null && offline != ""){
                newExpert.setOffline(true);
            }
            else {
                newExpert.setOnline(false);
            }


//        System.out.println(expertCountry.getId());

            if (id != null && id != ""){
//            Optional<Expert> byId = expertRepo.findById(Long.parseLong(id));
//            newExpert.setId(byId.get(0).getId());
//            Optional<Expert> byId = Optional.of(expertRepo.findById(Long.parseLong(id)));  JOPA

                Expert newExpert2 = expertRepo.findById(Long.parseLong(id)).get();
                newExpert.setId(newExpert2.getId());

//            Optional<Expert> byId = expertRepo.findById(Long.parseLong(id));
//            newExpert.setId(expertRepo.findById(Long.parseLong(id)).map(expert -> expert.getId()).orElseThrow(() -> new Exception()));
            }

            List<Tool> tools = toolRepo.findAll();
            List<ExpertTool> expertTools = new ArrayList<>();

            for (Map.Entry entry : form.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();


                for(Tool t : tools){
                    if (key.equals(t.getName())){
                        ExpertTool et = new ExpertTool(newExpert, t);
                        et.setRating(Integer.parseInt(value));
                        expertTools.add(et);
                    }
                }
//            if (value.equals()) {
//                List<Task> tt = taskRepo.findById(Integer.parseInt(key));
//                tasks.add(tt.get(0));
//            }
            }

            newExpert.setExpertTools(expertTools);
//        expertToolRepo.saveAll(expertTools);
            expertRepo.save(expert);
            return "redirect:/expertList";

//            taskService.saveTask(task, taskName, idt);
        }
        return "expertEdit";



    }
}

package com.example.ex2.controller;

import com.example.ex2.domain.Country;
import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Tool;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.CountryRepo;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ExpertToolRepo;
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
@RequestMapping("/expertList")
@PreAuthorize("hasAuthority('MOD2')")
public class ExpertController {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private ExpertToolRepo expertToolRepo;
    @Autowired
    private CountryRepo countryRepo;



    @GetMapping
    public String ExpertList(Model model){

        model.addAttribute("experts", expertRepo.findAll());
        return "expertList";
    }

    @GetMapping("/expert/edit/{expert}")
    public String expertEditForm(Model model,
                                 @PathVariable Expert expert){
        model.addAttribute("expert", expert);

        Long a = expert.getId(); //Без этой хуйни не работает

        List<ToolRate> rate = new ArrayList<>();
        List<ToolRate> curRate = new ArrayList<>();
        List<Country> countries = countryRepo.findAll();
//        List<Country> countries = countryRepo.findAllOrderByTitleRu();

        //Ебовая конструкция для проверки количества текущих инструментов
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
                if(tr.getToolname() == ctr.getToolname()){
                    tr.setRate(ctr.getRate());
                }
            }
        }


        model.addAttribute("countries", countries);
        model.addAttribute("rate", rate);
        return "expertEdit";
    }

    @GetMapping("/expert/new/")
    public String newExpert(Model model){
        Expert newExpert = new Expert();
        model.addAttribute("expert", newExpert);

        List<ToolRate> rate = new ArrayList<>();
        for(Tool t : toolRepo.findAll()){
            ToolRate tr = new ToolRate(t.getName(), 0);
            rate.add(tr);
        }
        model.addAttribute("rate", rate);

//        List<Integer> rate = new ArrayList<>();
//        for (int i = 0; i < 6; i++){
//            rate.add(i);
//        }
//        model.addAttribute("rate", rate);
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
        expertRepo.save(newExpert);
        return "redirect:/expertList";
    }




}

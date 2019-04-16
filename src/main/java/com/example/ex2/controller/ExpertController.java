package com.example.ex2.controller;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Tool;
import com.example.ex2.pojo.ToolRate;
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

    @GetMapping
    public String ExpertList(Model model){

        model.addAttribute("experts", expertRepo.findAll());
        return "expertList";
    }

    @GetMapping("/expert/edit/{expert}")
    public String expertEditForm(Model model,
                                 @PathVariable Expert expert){
        model.addAttribute("expert", expert);
        model.addAttribute("tools", toolRepo.findAll());
        int a = expert.getId();

        List<ToolRate> rate = new ArrayList<>();
        List<ToolRate> arate = new ArrayList<>();

        for(Tool t : toolRepo.findAll()){
            ToolRate tr = new ToolRate(t.getName());
            rate.add(tr);
        }

//        for(ExpertTool et : expert.getExpertTools()){
//            ToolRate tr = new ToolRate(et.getTool().getName(), et.getRating());
//            rate.add(tr);
//        }
//        for(ExpertTool et : expert.getExpertTools()){
//            ToolRate tr = new ToolRate(et.getTool().getName(), et.getRating());
//            arate.add(tr);
//        }
//
//        for(ToolRate tr : arate){
//            if(tr.getRate() != )
//
//        }

        model.addAttribute("rate", rate);

//        if (expert.getExpertTools() != null && expert.getExpertTools().size() != 0){
//            for(ToolRate tr : rate){
//                if
//
//            }
//        }


//        List<Integer> rate = new ArrayList<>();
//        for (int i = 0; i < 6; i++){
//            rate.add(i);
//        }
//
//        List<ToolRate> rat = new ArrayList<>();
//
//        for(Tool t : toolRepo.findAll()){
//            for(ExpertTool et : expert.getExpertTools()){
//                if(t.getId().equals(et.getTool().getId())){
//                    ToolRate tr = new ToolRate(et.getTool().getName(), et.getRating());
//                    rat.add(tr);
//                }
//                else {
//                    ToolRate tr = new ToolRate(t.getName(), 0);
//                    rat.add(tr);
//                }
//
//            }
//        }
//
//
//        model.addAttribute("rat", rat);
//        model.addAttribute("rate", rate);

        return "expertEdit";
    }

    @GetMapping("/expert/new/")
    public String newExpert(Model model){
        Expert newExpert = new Expert();
        model.addAttribute("expert", newExpert);
        model.addAttribute("tools", toolRepo.findAll());

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
            List<Expert> byId = expertRepo.findById(Integer.parseInt(id));
            newExpert.setId(byId.get(0).getId());
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

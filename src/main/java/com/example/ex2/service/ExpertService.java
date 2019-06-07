package com.example.ex2.service;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Language;
import com.example.ex2.domain.Tool;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.CountryRepo;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.LangRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpertService {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private LangRepo langRepo;

    public Expert findById(String value){
        //TODO возвращение пустого экзмеляра если null
        return expertRepo.findById(Long.parseLong(value)).get();
    }

    public List<ToolRate> getToolRateWithZeros(){
        List<ToolRate> rate = new ArrayList<>();
        for(Tool t : toolRepo.findAllByOrderByNameAsc()){
            rate.add(new ToolRate(t.getName(), 0));
        }
        return rate;
    }

    public void setAccessType(@Valid Expert expert, String online, String offline){

        if (!StringUtils.isEmpty(online)){
            expert.setOnline(true);
        } else {
            expert.setOnline(false);
        }

        if (!StringUtils.isEmpty(offline)){
            expert.setOffline(true);
        } else {
            expert.setOffline(false);
        }
    }

    public void makeEditForm(@Valid Expert expert, Model model){
        //Получение текущих инструментов и заполнение рейтинга нулями
        List<ToolRate> rate = getToolRateWithZeros();

        List<ToolRate> curRate = new ArrayList<>();


//        for(Tool t : toolService.findAllByNameAsc()){
//            rate.add(new ToolRate(t.getName(), 0));
//        }

        //Добавление проставленных оценок
        for(ExpertTool et : expert.getExpertTools()){
            curRate.add(
                    new ToolRate(
                            et.getTool().getName(), et.getRating()));
        }

        //
        for(ToolRate tr : rate){
            for(ToolRate ctr : curRate){
                if(tr.getToolname().equals(ctr.getToolname())){
                    tr.setRate(ctr.getRate());
                }
            }
        }



        model.addAttribute("countries", countryRepo.findAllByOrderByTitleruAsc());
        model.addAttribute("langs", langRepo.findAllByOrderByTitleruAsc());
        model.addAttribute("rate", rate);
    }

    public void saveExpert(@Valid Expert expert,
                           String online,
                           String offline,
                           String id,
                           Map<String, String> form){

        setAccessType(expert, online, offline);
//        System.out.println(expertCountry.getId());

        if (!StringUtils.isEmpty(id)){
            expert.setId(findById(id).getId());
        }

        parseAndSetToolRate(expert, form);

        expert.setLang(parseLangs(form));
        expertRepo.save(expert);
    }

    public void parseAndSetToolRate(@Valid Expert expert, Map<String, String> form){
        List<Tool> tools = toolRepo.findAll();
        List<ExpertTool> expertTools = new ArrayList<>();

        for (Map.Entry entry : form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();


            for(Tool t : tools){
                if (key.equals(t.getName())){
                    ExpertTool et = new ExpertTool(expert, t);
                    et.setRating(Integer.parseInt(value));
                    expertTools.add(et);
                }
            }
        }

        expert.setExpertTools(expertTools);
    }

    public List<Language> parseLangs(Map<String, String> form){
        List<Language> langs = new ArrayList<>();
        for (Map.Entry entry : form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (value.equals("on")) {
                if(!key.equals("offline")){
                    if(!key.equals("online")){
//                    if (!key.contains("online") || !key.contains("offline")){

                        Language l = langRepo.findById(Long.parseLong(key)).get();
                        langs.add(l);
                    }
                }

//                List<Language> l = langRepo.findById(Long.parseLong(key)).get();
//                tasks.add(tt.get(0));
//                Long lid = Long.parseLong(key);
//                Language l = langRepo.findById(Long.parseLong(key)).get();
//                if(!l.equals(null)){
//                    langs.add(l);

//                langs.add(langRepo.findById(Long.parseLong(key)).get());
            }
        }
        return langs;
    }
}

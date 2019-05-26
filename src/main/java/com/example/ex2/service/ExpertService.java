package com.example.ex2.service;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Tool;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    private ToolService toolService;

    public Expert findById(String value){
        //TODO возвращение пустого экзмеляра если null
        return expertRepo.findById(Long.parseLong(value)).get();
    }

    public List<ToolRate> getToolRate(){
        List<ToolRate> rate = new ArrayList<>();
        for(Tool t : toolRepo.findAllByOrderByNameAsc()){
            rate.add(new ToolRate(t.getName(), 0));
        }
        return rate;
    }

    public void makeEditForm(Model model, Expert expert){
        //Получение текущих инструментов и заполнение рейтинга нулями
        List<ToolRate> rate = getToolRate();
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

        model.addAttribute("rate", rate);
    }

    public void saveExpert(@Valid Expert expert){

    }

    public void parseLangs(Map<String, String> form){

    }
}

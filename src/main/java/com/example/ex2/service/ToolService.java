package com.example.ex2.service;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

@Service
public class ToolService {
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private ExpertRepo expertRepo;

    public void saveTool(@Valid Tool tool, String toolname, String idt){

        if (!StringUtils.isEmpty(idt)){
            tool.setId(Integer.parseInt(idt));
            toolRepo.save(tool);
        } else {
            toolRepo.save(tool);
            List<Expert> experts = expertRepo.findAll();
            for(Expert e : experts){
                ExpertTool et = new ExpertTool(e, tool);
                et.setRating(0);
                e.getExpertTools().add(et);
                expertRepo.save(e);
            }
        }

//        tool.setName(toolname); //присвоение названия

    }

//    public void addTool(@Valid Tool tool, String toolname){
//
//    }

    public List<Tool> findAllByNameAsc(){
        return toolRepo.findAllByOrderByNameAsc();
    }

}

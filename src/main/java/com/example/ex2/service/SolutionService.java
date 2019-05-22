package com.example.ex2.service;

import com.example.ex2.domain.Tool;
import com.example.ex2.domain.dto.ExpertDto;
import com.example.ex2.domain.dto.ExpertToolDto;
import com.example.ex2.pojo.ToolRate;
import com.example.ex2.repos.ExpertRepo;
import com.example.ex2.repos.ExpertToolRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SolutionService {
    @Autowired
    private ExpertRepo expertRepo;
    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private ExpertToolRepo expertToolRepo;
//    @Autowired
//    private EntityManager em;

//    public Set<ExpertToolDto> parseSolutionForm(Map<String, String> form){
//        Set<ExpertToolDto> marks = new LinkedHashSet<>();
//
//        for (Map.Entry entry : form.entrySet()) {
//            String key = entry.getKey().toString();
//            String value = entry.getValue().toString();
//
//            List<Tool> tt = toolRepo.findByName(key);
//            if(tt.size() > 0){
//                marks.add(new ToolRate(tt.get(0), Integer.parseInt(value)));
////                marks.put(tt.get(0), Integer.parseInt(value));
//            }
//        }
//        return marks;
//    }

    public Set<ToolRate> parseSolutionForm(Map<String, String> form){
        Set<ToolRate> marks = new LinkedHashSet<>();

        for (Map.Entry entry : form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();

            List<Tool> tt = toolRepo.findByName(key);
            if(tt.size() > 0){
                marks.add(new ToolRate(tt.get(0), Integer.parseInt(value)));
//                marks.put(tt.get(0), Integer.parseInt(value));
            }
        }
        return marks;
    }

    public Set<ExpertDto> getExpertsByTools(Set<ToolRate> marks){
//    public List<Expert> getExpertsByTools(Set<ToolRate> marks){

        Set<ExpertDto> experts = new LinkedHashSet<>();

        for(ToolRate tr : marks){
            Tool t = toolRepo.findById(tr.getToolid()).get();
            List<ExpertDto> exps = expertRepo.findByToolAndRate(t, tr.getRate());

            for (ExpertDto expertDto : exps){
                int marksSize = marks.size();
                int i = 0;
                for(ExpertToolDto etd : expertDto.getExpertToolDtos()){
                    for(ToolRate toolRate : marks){
                        if(etd.getToolId().equals(toolRate.getToolid()) && etd.getRating() >= toolRate.getRate()){
                            i++;
                        }
                    }
                }

                if(i == marksSize){
                    experts.add(expertDto);
                }
            }
        }
        return experts;
    }

}

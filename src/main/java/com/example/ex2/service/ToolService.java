package com.example.ex2.service;

import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;

@Service
public class ToolService {
    @Autowired
    private ToolRepo toolRepo;

    public void saveTool(@Valid Tool tool, String toolname, String idt){

        if (!StringUtils.isEmpty(idt)){
            tool.setId(Integer.parseInt(idt));
        }

        tool.setName(toolname); //присвоение названия

        toolRepo.save(tool);

    }

}

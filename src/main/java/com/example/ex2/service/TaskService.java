package com.example.ex2.service;

import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import com.example.ex2.repos.TaskRepo;
import com.example.ex2.repos.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ToolRepo toolRepo;

    public void saveTask(@Valid Task task, String taskname, String idt){

        if (!StringUtils.isEmpty(idt)){
            task.setId(Integer.parseInt(idt));
        }

        task.setName(taskname); //присвоение названия

        taskRepo.save(task);

    }

    public void setTools(@Valid Task task, Map<String, String> form){
        List<Tool> tools = new ArrayList<>();

        for (Map.Entry entry : form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();

            if (value.equals("on")) {
                List<Tool> tt = toolRepo.findById(Integer.parseInt(key));
                tools.add(tt.get(0));
            }
        }

        if(task.getTools() != null){
            task.getTools().clear();
        }
        task.setTools(tools);
    }
}

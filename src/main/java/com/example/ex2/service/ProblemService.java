package com.example.ex2.service;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import com.example.ex2.repos.ProblemRepo;
import com.example.ex2.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProblemService {
    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TaskRepo taskRepo;

    public void saveTask(@Valid Problem problem, String problemname, String idp){

        if (!StringUtils.isEmpty(idp)){
            problem.setId(Integer.parseInt(idp));
        }

        problem.setName(problemname); //присвоение названия
        problemRepo.save(problem);
    }

    public void setTasksAndType(@Valid Problem problem, String problemType, Map<String, String> form){
        if(!StringUtils.isEmpty(problemType)) {
            if (problemType.equals("1")) { //присвоение типа
                problem.setType(true);
            } else {
                problem.setType(false);
            }
        }

        List<Task> tasks = new ArrayList<>();

        for (Map.Entry entry : form.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (value.equals("on")) {
                List<Task> tt = taskRepo.findById(Integer.parseInt(key));
                tasks.add(tt.get(0));
            }
        }
        if(problem.getTasks() != null){
            problem.getTasks().clear();
        }

        problem.setTasks(tasks);
    }
}

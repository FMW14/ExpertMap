package com.example.ex2.repos;

import com.example.ex2.domain.Task;
import com.example.ex2.domain.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepo extends JpaRepository<Tool, Integer>{
    List<Tool> findByTasks(Task task);
    List<Tool> findById(int i);
    List<Tool> findByName(String s);
}



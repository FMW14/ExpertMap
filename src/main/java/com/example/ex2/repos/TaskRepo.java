package com.example.ex2.repos;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByProblems(Problem problem);
    List<Task> findAllByOrderByNameAsc();
    List<Task> findByName(String s);
    List<Task> findById(int i);
}



package com.example.ex2.repos;

import com.example.ex2.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}



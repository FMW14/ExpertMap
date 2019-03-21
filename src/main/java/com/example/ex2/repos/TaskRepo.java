package com.example.ex2.repos;

import com.example.ex2.domain.Problem;
import com.example.ex2.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
//    @Query(value = "select tasks_id from problem_tasks where problems_id = ?", nativeQuery = true)
//    Task findByProblem(String problemname);

//    @Query(value = "select tasks_id from problem_tasks where problems_id = ?1", nativeQuery = true)
    List<Task> findByProblems(Problem problem);
    List<Task> findByName(String s);
    List<Task> findById(int i);
}



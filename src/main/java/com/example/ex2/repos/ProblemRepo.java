package com.example.ex2.repos;

import com.example.ex2.domain.Problem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepo extends CrudRepository<Problem, Integer> {
        //List<Problem> findByLogin(String login);
        }

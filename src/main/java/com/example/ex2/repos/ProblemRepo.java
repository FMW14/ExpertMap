package com.example.ex2.repos;

import com.example.ex2.domain.Problem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepo extends CrudRepository<Problem, Integer> {
        //List<problemEdit.ftl> findByLogin(String login);
        List<Problem> findById(int id);
        }

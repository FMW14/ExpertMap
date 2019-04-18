package com.example.ex2.repos;

import com.example.ex2.domain.Expert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpertRepo extends CrudRepository<Expert, Long> {
//    List<Expert> findById(Long i);
    List<Expert> findByName(String s);

}

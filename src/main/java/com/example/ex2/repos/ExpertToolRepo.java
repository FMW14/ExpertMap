package com.example.ex2.repos;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ExpertToolRepo extends CrudRepository<Expert, Tool> {

}

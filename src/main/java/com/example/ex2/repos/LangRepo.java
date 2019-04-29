package com.example.ex2.repos;

import com.example.ex2.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LangRepo extends CrudRepository<Language, Long> {


}

package com.example.ex2.repos;

import com.example.ex2.domain.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LangRepo extends CrudRepository<Language, Long> {
    List<Language> findAllByOrderByTitleruAsc();
}

package com.example.ex2.repos;

import com.example.ex2.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepo extends JpaRepository<Country, Long> {
//    List<Country> findByTitle_ru(String s);
//    List<Country> findAllOrderByTitleRu();
}

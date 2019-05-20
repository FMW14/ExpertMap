package com.example.ex2.repos;

import com.example.ex2.domain.Country;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepo extends CrudRepository<Country, Long> {

//    @Query("select all from User u where u.emailAddress = ?1")
//    @Query(value = "SELECT * FROM _countries ORDER BY title_ru", nativeQuery = true)
//    @Query(value = "SELECT title_ru as tr, title_en as tn, country_id FROM _countries ORDER BY tr")
//    List<Country> findC();

    List<Country> findAllByOrderByTitleruAsc();

//    List<Country> findByTitle_ru(String s);
//    List<Country> findC();
}

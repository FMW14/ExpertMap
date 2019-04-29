package com.example.ex2.repos;

import com.example.ex2.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<Country, Long> {


}

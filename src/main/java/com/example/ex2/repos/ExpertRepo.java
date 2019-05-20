package com.example.ex2.repos;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.Tool;
import com.example.ex2.domain.dto.ExpertDto;
import com.example.ex2.domain.dto.ExpertToolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpertRepo extends JpaRepository<Expert, Long> {

    List<Expert> findByName(String s);

    @Query("select new com.example.ex2.domain.dto.ExpertDto(t) from Expert t left join t.expertTools et where et.tool = :nt and et.rating >= :rate")
    List<ExpertDto> findByToolAndRate(@Param("nt")Tool nt, @Param("rate")Integer rate);

}

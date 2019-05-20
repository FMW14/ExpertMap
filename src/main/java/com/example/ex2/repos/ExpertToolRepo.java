package com.example.ex2.repos;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.ExpertToolId;
import com.example.ex2.domain.Tool;
import com.example.ex2.domain.dto.ExpertToolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpertToolRepo extends JpaRepository<ExpertTool, ExpertToolId> {

//    @Query("select new com.example.ex2.domain.dto.ExpertToolDto(et, et.rating) from ExpertToolEntity et where et.tool = :nt and et.rating >= :rate")
//    List<ExpertToolDto> findByTool(@Param("nt")Tool nt, @Param("rate")Integer rate);
}

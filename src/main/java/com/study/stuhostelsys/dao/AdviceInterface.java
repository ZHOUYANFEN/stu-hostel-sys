package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AdviceInterface extends JpaRepository<Advice, Integer>, JpaSpecificationExecutor<Advice>{

    @Query("SELECT a.content FROM Advice a WHERE a.id=?1")
    String findAllById(Integer id);
}

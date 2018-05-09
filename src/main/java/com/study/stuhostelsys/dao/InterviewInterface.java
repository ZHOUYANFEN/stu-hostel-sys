package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InterviewInterface extends JpaRepository<Interview, Integer>, JpaSpecificationExecutor<Interview> {

}

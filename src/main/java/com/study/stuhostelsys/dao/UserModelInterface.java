package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.common.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelInterface extends JpaRepository<userModel,Integer>{
}

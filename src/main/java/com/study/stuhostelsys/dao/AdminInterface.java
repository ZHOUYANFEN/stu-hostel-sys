package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminInterface extends JpaRepository<Admin, Integer> {

}

package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminInterface extends JpaRepository<Admin, Integer> {

}

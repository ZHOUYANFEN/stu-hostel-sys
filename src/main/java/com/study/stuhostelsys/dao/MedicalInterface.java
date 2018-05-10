package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Medical;
import net.sf.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MedicalInterface extends JpaRepository<Medical, Integer>, JpaSpecificationExecutor<Medical> {

    @Query("UPDATE Medical l SET l.userName=?2, l.userId=?3, l.userTel=?4, l.allergy=?5, l.meHistory=?6 WHERE l.id=?1")
    @Modifying
    @Transactional
    void updateMedical(Integer id,String userName,String userId,String userTel,String allergy,String meHistory);

    @Query("SELECT l FROM Medical l WHERE l.id=?1")
    JSONArray findAllById(Integer id);
}

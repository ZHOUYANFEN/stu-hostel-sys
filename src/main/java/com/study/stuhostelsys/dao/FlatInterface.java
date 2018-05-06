package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FlatInterface extends JpaRepository<Flat, Integer>, JpaSpecificationExecutor<Flat> {

    @Query("DELETE FROM Flat f WHERE f.adminId=?1 AND f.flatName=?2 AND f.flatName=?3")
    @Modifying
    @Transactional
    void deleteFlatByAdminIdAndFlat(String adminId, String flatName, String flatNum);


}

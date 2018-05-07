package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Flat;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlatInterface extends JpaRepository<Flat, Integer>, JpaSpecificationExecutor<Flat> {

    @Query("DELETE FROM Flat f WHERE f.adminId=?1 AND f.flatName=?2 AND f.flatName=?3")
    @Modifying
    @Transactional
    void deleteFlatByAdminIdAndFlat(String adminId, String flatName, String flatNum);

    @Query("UPDATE Flat f SET f.flatName=?2, f.flatNum=?3, f.flatUser=?4, f.flatUserId=?5, f.flatUserTel=?6, f.type=?7, f.size=?8, f.remark=?9 WHERE f.id=?1")
    @Modifying
    @Transactional
    void updateFlatById(Integer id, String flatName,
                        String flatNum,
                        String flatUser,
                        String flatUserId,
                        String flatUserTel,
                        String type,
                        String size,
                        String remark);

    @Query("SELECT f FROM Flat f WHERE f.adminId=?1")
    List<Flat> findAllByAdminId(String adminId);

    @Query("SELECT f FROM Flat f WHERE f.id=?1")
    List<Flat> findAllById(Integer id);
}

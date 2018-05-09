package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Serve;
import net.sf.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ServeInterface extends JpaRepository<Serve, Integer> {

    /**
     * 根据ID查公社服务信息
     * @param id
     * @return
     */
    @Query("SELECT s FROM Serve s WHERE s.id=?1")
    JSONArray findAllById(Integer id);

    @Query("update Serve s set s.flatName=?2, s.flatAddress=?3, s.flatUser=?4, s.flatUserTel=?5, s.type=?6, s.time=?7, s.status=?8,s.remark=?9 where s.id=?1")
    @Modifying
    @Transactional
    void updateServe(Integer id,
                     String flatName,
                     String flatAddress,
                     String flatUser,
                     String flatUserTel,
                     String type,
                     String time,
                     String status,
                     String remark);
}

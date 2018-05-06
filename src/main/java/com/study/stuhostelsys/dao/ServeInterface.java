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

    @Query("update Serve s set s.flatUserTel=?2, s.type=?3, s.time=?4, s.serve=?5, s.serveId=?6, s.serveTel=?7, s.remark=?8 where s.id=?1")
    @Modifying
    @Transactional
    void updateServe(Integer id,
                     String flatUserTel,
                     String type,
                     String time,
                     String serve,
                     String serveId,
                     String serveTel,
                     String remark);
}

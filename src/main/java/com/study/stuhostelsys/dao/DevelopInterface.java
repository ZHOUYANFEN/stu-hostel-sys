package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Develop;
import net.sf.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DevelopInterface extends JpaRepository<Develop, Integer> {

    /**
     * 修改第三方
     * @param id
     * @param devName
     * @param url
     * @param remark
     */
    @Query("UPDATE Develop d SET d.devName=?2, d.url=?3, d.remark=?4  WHERE d.id=?1")
    @Modifying
    @Transactional
    void updateDevelop(Integer id, String devName, String url, String remark);

    /**
     * 根据ID查用户信息
     * @param id
     * @return
     */
    @Query("SELECT d FROM Develop d WHERE d.id=?1")
    JSONArray findAllById(Integer id);
}

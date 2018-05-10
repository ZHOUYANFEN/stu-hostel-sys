package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Lib;
import net.sf.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LibInterface extends JpaRepository<Lib, Integer>, JpaSpecificationExecutor<Lib>{

    @Query("UPDATE Lib l SET l.userName=?2, l.userId=?3, l.userTel=?4, l.book=?5, l.borrowTime=?6, l.backTime=?7 WHERE l.id=?1")
    @Modifying
    @Transactional
    void updateLib(Integer id,String userName,String userId,String userTel,String book,String borrowTime,String backTime);

    @Query("SELECT l FROM Lib l WHERE l.id=?1")
    JSONArray findAllById(Integer id);
}

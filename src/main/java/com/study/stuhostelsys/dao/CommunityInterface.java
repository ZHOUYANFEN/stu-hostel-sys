package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface CommunityInterface extends JpaRepository<Community, Integer> {
    @Query("UPDATE Community c SET c.communityName=?2, c.address =?3, " +
            "c.adminId =?4, c.remark=?5, c.adminName=?6, c.flatName=?7  WHERE c.id=?1")
    @Modifying
    @Transactional
    void updateDevelop(Integer id, String communityName, String address,
                       Integer adminId, String remark, String adminName, String flatName);

}

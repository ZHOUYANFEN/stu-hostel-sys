package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AdminInterface extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {

    /**
     * 登录校验
     * @param userName
     * @param userPassword
     * @return
     */
    Admin findByUserNameAndUserPassword(String userName, String userPassword);

    /**
     * 修改密码
     * @param userName
     * @param userPassword
     */
    @Query("UPDATE Admin b SET b.userPassword=?2, b.power=?3 WHERE b.userName=?1")
    @Modifying
    @Transactional
    void updateUserPassword(String userName, String userPassword, String power);

}

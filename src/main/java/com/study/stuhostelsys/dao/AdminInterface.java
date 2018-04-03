package com.study.stuhostelsys.dao;

import com.study.stuhostelsys.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminInterface extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {

    Admin findByUserNameAndUserPassword(String userName, String userPassword);

    @Query("UPDATE Admin b SET b.userPassword=?2 WHERE b.userName=?1")
    @Modifying
    @Transactional
    void updateUserPassword(String userName, String userPassword);

}

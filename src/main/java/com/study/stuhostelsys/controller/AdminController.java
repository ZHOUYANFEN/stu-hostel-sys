package com.study.stuhostelsys.controller;

/**
 * 管理员权限表
 */
import com.study.stuhostelsys.dao.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminInterface adminInterface;


}

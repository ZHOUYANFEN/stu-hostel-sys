package com.study.stuhostelsys.controller;

/**
 * 公共服务表
 */
import com.study.stuhostelsys.dao.ServeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServeController {

    @Autowired
    private ServeInterface serveInterface;
}

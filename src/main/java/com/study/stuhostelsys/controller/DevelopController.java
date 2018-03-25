package com.study.stuhostelsys.controller;

/**
 * 第三方拓展表
 */
import com.study.stuhostelsys.dao.DevelopInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevelopController {

    @Autowired
    private DevelopInterface developInterface;
}

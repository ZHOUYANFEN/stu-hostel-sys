package com.study.stuhostelsys.controller;

/**
 * 公社表
 */
import com.study.stuhostelsys.dao.CommunityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

    @Autowired
    private CommunityInterface communityInterface;
}

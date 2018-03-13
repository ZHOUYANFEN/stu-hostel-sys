package com.study.stuhostelsys.controller;

import com.study.stuhostelsys.dao.UserModelInterface;
import com.study.stuhostelsys.common.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private UserModelInterface userModelInterface;

    @GetMapping(value = "/users")
    public List<userModel> userModelList() {
        return userModelInterface.findAll();
    }
}

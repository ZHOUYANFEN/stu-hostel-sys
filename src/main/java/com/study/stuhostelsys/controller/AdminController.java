package com.study.stuhostelsys.controller;

/**
 * 管理员权限表
 */
import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminInterface adminInterface;

    /**
     * 视图绑定
     * @return
     */
    @RequestMapping(value = "/admin")
    public ModelAndView admin(){
        ModelAndView index = new ModelAndView("admin");
        return index;
    }

    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestParam("admin") Admin admin){
        return adminInterface.save(admin);
    }

    @GetMapping("/getAdminList")
    public List<Admin> getAdminList(){
        return adminInterface.findAll();
    }

}

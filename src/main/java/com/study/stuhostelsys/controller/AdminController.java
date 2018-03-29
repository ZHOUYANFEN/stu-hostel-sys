package com.study.stuhostelsys.controller;

/**
 * 管理员权限表
 */
import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminInterface adminInterface;

    /**
     * 视图绑定
     * @return
     */
    @RequestMapping(value = "/admin")
    public ModelAndView admin(){
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @PostMapping("/saveAdmin")
    public @ResponseBody String saveAdmin(@RequestParam String userName, @RequestParam String userPassword, @RequestParam String power, HttpServletRequest request, HttpServletResponse response){
        Admin admin = new Admin();
        admin.setUser_name(userName);
        admin.setUser_password(userPassword);
        admin.setPower(power);
        try {
            adminInterface.save(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    @GetMapping("/getAdminList")
    public List<Admin> getAdminList(){
        return adminInterface.findAll();
    }

}

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
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminInterface adminInterface;

    /**
     * 跳转login页
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView login = new ModelAndView("login");
        return login;
    }

    /**
     * 登录 - signin
     * @param userName
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/signin")
    public @ResponseBody Admin signin(@RequestParam String userName,
                        @RequestParam String userPassword,
                        HttpServletRequest request,HttpServletResponse response) {
        Admin admin = new Admin();
        try {
            admin = adminInterface.findByUserNameAndUserPassword(userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /**
     * 修改密码
     * @param userName
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/updateUserPassword")
    public @ResponseBody Boolean updateUserPassword(@RequestParam String userName,
                                     @RequestParam String userPassword,
                                     HttpServletRequest request,HttpServletResponse response){
        boolean i = false;
        try {
            adminInterface.updateUserPassword(userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 新增admin
     * @param userName
     * @param userPassword
     * @param power
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/saveAdmin")
    public @ResponseBody String saveAdmin(@RequestParam String userName,
                                          @RequestParam String userPassword,
                                          @RequestParam String power,
                                          HttpServletRequest request, HttpServletResponse response){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setUserPassword(userPassword);
        admin.setPower(power);
        try {
            adminInterface.save(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    /**
     * 所有admin
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/getAdminList")
    public @ResponseBody List<Admin> getAdminList(HttpServletRequest request, HttpServletResponse response){
        List<Admin> admin = adminInterface.findAll();
        return admin;
    }

    /**
     * 跳转admin框架主页
     * @return
     */
    @RequestMapping(value = "/admin")
    public ModelAndView admin(){
        ModelAndView index = new ModelAndView("index");
        return index;
    }
}

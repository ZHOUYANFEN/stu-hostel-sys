package com.study.stuhostelsys.controller;

/**
 * 管理员权限表
 */
import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.model.Admin;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
    @ResponseBody
    public JSONObject signin(@RequestParam String userName,
                             @RequestParam String userPassword,
                             HttpServletRequest request, HttpServletResponse response,
                             Model model) {
        JSONObject result = new JSONObject();
        Admin admin = new Admin();
        try {
            admin = adminInterface.findByUserNameAndUserPassword(userName, userPassword);
            if(admin == null){
                result.put("msage", Boolean.FALSE);
                result.put("data", "用户名 / 密码错误！");
            } else {
                result.put("power", admin.getPower());
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", e.getMessage());
        }
        return result;
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
                                                    @RequestParam String power,
                                     HttpServletRequest request,HttpServletResponse response){
        boolean i = false;
        try {
            adminInterface.updateUserPassword(userName, userPassword, power);
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
        List<Admin> admin = new ArrayList<>();
        try {
            admin = adminInterface.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /**
     * 删除admin
     * @param id
     * @return
     */
    public @ResponseBody String deletAdmin(@RequestParam Integer id,@RequestParam String power){
        String data = "";
        try {
            if (!power.isEmpty() || !power.equals("2")){
                adminInterface.deleteById(id);
                data = "0";
            } else {
                data = "-1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 跳转admin框架主页
     * @return
     */
    @GetMapping(value = "/admin")
    public ModelAndView admin(@RequestParam("power") String power, Model model){
        ModelAndView index;
        if (power.equals("1")){
            index = new ModelAndView("sys_manage/index");
            model.addAttribute("model", index);
        } else {
            index = new ModelAndView("hostel/index");
            model.addAttribute("model", index);
        }
        return index;
    }
}

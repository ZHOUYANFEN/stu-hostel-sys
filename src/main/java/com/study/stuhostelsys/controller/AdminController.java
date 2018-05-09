package com.study.stuhostelsys.controller;

/**
 * 管理员权限表
 */

import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.dao.DevelopInterface;
import com.study.stuhostelsys.model.Admin;
import net.sf.json.JSONArray;
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

@Controller
public class AdminController {

    @Autowired
    private AdminInterface adminInterface;

    @Autowired
    private DevelopInterface developInterface;

    /**
     * 跳转login页
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView login = new ModelAndView("login");
        return login;
    }

    /**
     * 登录 - signin
     *
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
            if (admin == null) {
                result.put("msage", Boolean.FALSE);
                result.put("data", "用户名 / 密码错误！");
            } else {
                result.put("power", admin.getPower());
                result.put("id", admin.getId());
                model.addAttribute("userId", admin.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", e);
        }
        return result;
    }

    /**
     * 修改密码
     *
     * @param userName
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/updateUserPassword")
    public @ResponseBody
    JSONObject updateUserPassword(@RequestParam String userName,
                                  @RequestParam String userPassword,
                                  @RequestParam String power,
                                  @RequestParam Integer id,
                                  HttpServletRequest request, HttpServletResponse response) {
        JSONObject r = new JSONObject();
        try {
            adminInterface.updateUserPassword(userName, userPassword, power, id);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 新增admin
     *
     * @param userName
     * @param userPassword
     * @param power
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/saveAdmin")
    public @ResponseBody
    JSONObject saveAdmin(@RequestParam String userName,
                         @RequestParam String userPassword,
                         @RequestParam String power,
                         HttpServletRequest request, HttpServletResponse response) {
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setUserPassword(userPassword);
        admin.setPower(power);
        JSONObject r = new JSONObject();
        try {
            adminInterface.save(admin);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 所有admin
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/getAdminList")
    public @ResponseBody
    JSONObject getAdminList(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Admin> admin = new ArrayList<>();
        JSONObject obj = new JSONObject();
        try {
            admin = adminInterface.findAll();
            obj.put("data", admin);
            model.addAttribute("model", admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 删除admin
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteAdmin")
    public @ResponseBody
    JSONObject deleteAdmin(@RequestParam Integer id) {
        JSONObject r = new JSONObject();
        try {
            adminInterface.deleteById(id);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 跳转admin框架主页
     *
     * @return
     */
    @GetMapping(value = "/admin")
    public ModelAndView admin(@RequestParam("power") String power, Model model) {
        ModelAndView index;
        if (power.equals("1")) {
            index = new ModelAndView("sys_manage/index");
            model.addAttribute("model", index);
        } else {
            index = new ModelAndView("hostel/index");
            model.addAttribute("dev", developInterface.findAll());
        }
        return index;
    }

    /**
     * 根据ID查用户信息
     *
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/findAdminById")
    public @ResponseBody
    JSONObject findAdminById(@RequestParam Integer id, Model model) {
        JSONObject result = new JSONObject();
        result.put("admin", adminInterface.findAllById(id));
//        model.addAttribute("admin", result);
        return result;
    }

    @GetMapping("/root")
    public ModelAndView root() {
        ModelAndView root = new ModelAndView("sys_manage/root");
        return root;
    }
}

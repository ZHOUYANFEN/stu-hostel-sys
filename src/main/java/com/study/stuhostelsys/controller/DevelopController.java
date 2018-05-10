package com.study.stuhostelsys.controller;

/**
 * 第三方拓展表
 */
import com.study.stuhostelsys.dao.DevelopInterface;
import com.study.stuhostelsys.dao.LibInterface;
import com.study.stuhostelsys.dao.MedicalInterface;
import com.study.stuhostelsys.model.Develop;
import com.study.stuhostelsys.model.Lib;
import com.study.stuhostelsys.model.Medical;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DevelopController {

    @Autowired
    private DevelopInterface developInterface;

    @Autowired
    private LibInterface libInterface;

    @Autowired
    private MedicalInterface medicalInterface;

    @GetMapping("/develop")
    public ModelAndView develop(){
        ModelAndView root = new ModelAndView("sys_manage/develop");
        return root;
    }

    /**
     * 增加第三方信息
     * @param devName
     * @param url
     * @param remark
     * @return
     */
    @PostMapping("/saveDevelop")
    public @ResponseBody JSONObject saveDevelop(@RequestParam String devName,
                           @RequestParam String url,
                           @RequestParam String remark){
        JSONObject r = new JSONObject();
        Develop develop = new Develop();
        develop.setDevName(devName);
        develop.setUrl(url);
        develop.setRemark(remark);
        try {
            developInterface.save(develop);
            r.put("data","0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error",e.getMessage());
        }
        return r;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/deleteDevelop")
    public @ResponseBody JSONObject deleteDevelop(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            if (id != null){
                developInterface.deleteById(id);
                r.put("data", "0");
            } else {
                r.put("data", "id为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 修改第三方
     * @param id
     * @param devName
     * @param url
     * @param remark
     * @return
     */
    @PostMapping("/updateDevelop")
    public @ResponseBody JSONObject updateDevelop(@RequestParam Integer id,
                                               @RequestParam String devName,
                                               @RequestParam String url,
                                               @RequestParam String remark){
        JSONObject r = new JSONObject();
        try {
            if (id != null){
                developInterface.updateDevelop(id, devName, url, remark);
                r.put("data", "0");
            } else {
                r.put("data", "id不能为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 查看第三方
     * @return
     */
    @PostMapping("/getDevelopList")
    public @ResponseBody JSONObject getDevelopList(Model model){
        List<Develop> develop = null;
        JSONObject obj = new JSONObject();
        try {
            develop = developInterface.findAll();
            obj.put("data",develop);
            model.addAttribute("model", develop);
        } catch (Exception e) {
            e.printStackTrace();
            obj.put("data","-1");
            obj.put("error", e.getMessage());
        }
        return obj;
    }

    /**
     * 根据ID查Dev
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/findDevelopById")
    public JSONObject findDevelopById(@RequestParam Integer id, Model model){
        JSONObject result = new JSONObject();
        result.put("develop",developInterface.findAllById(id));
        model.addAttribute("develop", result);
        return result;
    }

    @GetMapping("/lib")
    public ModelAndView lib(){
        ModelAndView view = new ModelAndView("sys_manage/lib");
        return view;
    }
    @GetMapping("/medical")
    public ModelAndView medical(){
        ModelAndView view = new ModelAndView("sys_manage/medical");
        return view;
    }
    /**
     * 增
     */
    @PostMapping("/saveLib")
    @ResponseBody
    public JSONObject saveLib(@RequestParam String userName,
                              @RequestParam String userId,
                              @RequestParam String userTel,
                              @RequestParam String book,
                              @RequestParam String borrowTime,
                              @RequestParam String backTime){
        JSONObject r = new JSONObject();
        Lib lib = new Lib();
        lib.setUserName(userName);
        lib.setUserId(userId);
        lib.setUserTel(userTel);
        lib.setBook(book);
        lib.setBorrowTime(borrowTime);
        lib.setBackTime(backTime);
        try {
            libInterface.save(lib);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error", e);
        }
        return r;
    }

    @PostMapping("/saveMedical")
    @ResponseBody
    public JSONObject saveMedical(@RequestParam String userName,
                              @RequestParam String userId,
                              @RequestParam String userTel,
                              @RequestParam String allergy,
                              @RequestParam String meHistory){
        JSONObject r = new JSONObject();
        Medical me = new Medical();
        me.setUserName(userName);
        me.setUserId(userId);
        me.setUserTel(userTel);
        me.setAllergy(allergy);
        me.setMeHistory(meHistory);
        try {
            medicalInterface.save(me);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 改
     * @param id
     * @param userName
     * @param userId
     * @param userTel
     * @param book
     * @param borrowTime
     * @param backTime
     * @return
     */
    @PostMapping("/updateLib")
    @ResponseBody
    public JSONObject updateLib(@RequestParam Integer id,
                     @RequestParam String userName,
                     @RequestParam String userId,
                     @RequestParam String userTel,
                     @RequestParam String book,
                     @RequestParam String borrowTime,
                     @RequestParam String backTime){
        JSONObject r = new JSONObject();
        try {
            libInterface.updateLib(id,userName,userId,userTel,book,borrowTime,backTime);
            r.put("data","0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error",e);
        }
        return r;
    }
    @PostMapping("/updateMedical")
    @ResponseBody
    public JSONObject updateMedical(@RequestParam Integer id,
                                @RequestParam String userName,
                                @RequestParam String userId,
                                @RequestParam String userTel,
                                @RequestParam String allergy,
                                @RequestParam String meHistory){
        JSONObject r = new JSONObject();
        try {
            medicalInterface.updateMedical(id,userName,userId,userTel,allergy,meHistory);
            r.put("data","0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error",e);
        }
        return r;
    }

    /**
     * 查
     */
    @PostMapping("/getLibList")
    @ResponseBody
    public JSONObject getLibList(){
        JSONObject r = new JSONObject();
        List<Lib> lib = new ArrayList<>();
        try {
            lib = libInterface.findAll();
            r.put("data", lib);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error",e);
        }
        return r;
    }
    @PostMapping("/getMedicalList")
    @ResponseBody
    public JSONObject getMedicalList(){
        JSONObject r = new JSONObject();
        List<Medical> medical = new ArrayList<>();
        try {
            medical = medicalInterface.findAll();
            r.put("data", medical);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error",e);
        }
        return r;
    }

    @PostMapping("/findLibById")
    @ResponseBody
    public JSONObject findLibById(@RequestParam Integer id) {
        JSONObject result = new JSONObject();
        result.put("data", libInterface.findAllById(id));
        return result;
    }
    @PostMapping("/findMedicalById")
    @ResponseBody
    public JSONObject findMedicalById(@RequestParam Integer id) {
        JSONObject result = new JSONObject();
        result.put("data", medicalInterface.findAllById(id));
        return result;
    }

}

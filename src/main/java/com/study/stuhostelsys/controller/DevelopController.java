package com.study.stuhostelsys.controller;

/**
 * 第三方拓展表
 */
import com.study.stuhostelsys.dao.DevelopInterface;
import com.study.stuhostelsys.model.Develop;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DevelopController {

    @Autowired
    private DevelopInterface developInterface;

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
}

package com.study.stuhostelsys.controller;

/**
 * 第三方拓展表
 */
import com.study.stuhostelsys.dao.DevelopInterface;
import com.study.stuhostelsys.model.Develop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DevelopController {

    @Autowired
    private DevelopInterface developInterface;

    /**
     * 增加第三方信息
     * @param devName
     * @param url
     * @param remark
     * @return
     */
    @PostMapping("/saveDevelop")
    public @ResponseBody String saveDevelop(@RequestParam String devName,
                                           @RequestParam String url,
                                           @RequestParam String remark){
        String data = "";
        Develop develop = new Develop();
        develop.setDevName(devName);
        develop.setUrl(url);
        develop.setRemark(remark);
        try {
            developInterface.save(develop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/deletDevelop")
    public @ResponseBody String deletDevelop(@RequestParam Integer id){
        String data = "";
        try {
            if (id != null){
                developInterface.deleteById(id);
                data = "0";
            } else {
                data = "-1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            data = "-1";
        }
        return data;
    }

    /**
     * 修改第三方
     * @param id
     * @param devName
     * @param url
     * @param remark
     * @return
     */
    @PostMapping("/updateDdevelop")
    public @ResponseBody String updateDdevelop(@RequestParam Integer id,
                                               @RequestParam String devName,
                                               @RequestParam String url,
                                               @RequestParam String remark){
        String data = "";
        try {
            if (id != null){
                developInterface.updateDevelop(id, devName, url, remark);
                data = "0";
            } else {
                data = "id不能为空！";
            }
        } catch (Exception e) {
            e.printStackTrace();
            data = "-1";
        }
        return data;
    }

    /**
     * 查看第三方
     * @return
     */
    @PostMapping("" +
            "")
    public @ResponseBody List<Develop> getDdevelopList(){
        List<Develop> develop = null;
        try {
            develop = developInterface.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return develop;
    }
}

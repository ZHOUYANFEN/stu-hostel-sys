package com.study.stuhostelsys.controller;

/**
 * 公社表
 */
import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.dao.CommunityInterface;
import com.study.stuhostelsys.model.Community;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CommunityController {

    @Autowired
    private CommunityInterface communityInterface;

    @Autowired
    private AdminInterface adminInterface;

    @GetMapping("/community")
    public ModelAndView community(Model model){
        model.addAttribute("admin", adminInterface.findAll());
        return new ModelAndView("sys_manage/community");
    }

    /**
     * 增加公社信息
     * @param adminId
     * @param adminName
     * @param flatName
     * @param address
     * @param remark
     * @param communityName
     * @return
     */
    @PostMapping("/saveCommunity")
    public @ResponseBody JSONObject saveCommunity(@RequestParam Integer adminId,
                                                  @RequestParam String adminName,
                                                  @RequestParam String flatName,
                                                  @RequestParam String address,
                                                  @RequestParam String remark,
                                                  @RequestParam String communityName){
        JSONObject r = new JSONObject();
        Community com = new Community();
        try {
            com.setAdminId(adminId); // admin_id
            com.setAdminName(adminName); // admin_name
            com.setFlatName(flatName); // flat_name;
            com.setAddress(address); // address
            com.setRemark(remark); // remark
            com.setCommunityName(communityName); //community_name
            communityInterface.save(com);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 删除公社信息
     * @param id
     * @return
     */
    @PostMapping("/deleteCommunity")
    public @ResponseBody JSONObject deleteCommunity(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            if (id != null){
                communityInterface.deleteById(id);
                r.put("data", "0");
            } else {
                r.put("data", "-1");
                r.put("error", "id不能为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 修改公社信息
     * @param id
     * @param adminId
     * @param adminName
     * @param flatName
     * @param address
     * @param remark
     * @param communityName
     * @return
     */
    @PostMapping("/updateCommunity")
    public @ResponseBody JSONObject updateCommunity(@RequestParam Integer id,
                                                    @RequestParam Integer adminId,
                                                    @RequestParam String adminName,
                                                    @RequestParam String flatName,
                                                    @RequestParam String address,
                                                    @RequestParam String remark,
                                                    @RequestParam String communityName){
        JSONObject r = new JSONObject();
        try {
            if (id != null){
                communityInterface.updateDevelop(id,communityName, address,adminId,remark,adminName,flatName);
                r.put("data", "0");
            } else {
                r.put("data", "-1");
                r.put("error", "community为空！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 查看公社信息
     * @return
     */
    @PostMapping("/getCommunityList")
    public @ResponseBody JSONObject getCommunityList(Model model){
        List<Community> communityList = new ArrayList<>();
        JSONObject obj = new JSONObject();
        try {
            communityList = communityInterface.findAll();
            obj.put("data", communityList);
            model.addAttribute("model", communityList);
        } catch (Exception e) {
            e.printStackTrace();
            obj.put("error", e);
        }
        return obj;
    }

    /**
     * 根据Id查Community
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/findCommById")
    public JSONObject findCommById(@RequestParam Integer id, Model model){
        JSONObject r = new JSONObject();
        r.put("comm", communityInterface.findAllById(id));
        model.addAttribute("comm", r);
        return r;
    }

}

package com.study.stuhostelsys.controller;

/**
 * 公社表
 */
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

    @GetMapping("/community")
    public ModelAndView community(){
        return new ModelAndView("sys_manage/community");
    }

    /**
     * 增加公社信息
     * @param community
     * @return
     */
    @PostMapping("/saveCommunity")
    public @ResponseBody JSONObject saveCommunity(@RequestParam Map<String, Object> community){
        JSONObject r = new JSONObject();
        Community com = new Community();
        try {
            com.setAdminId(Integer.parseInt(community.get("adminId").toString())); // admin_id
            com.setAdminName(community.get("adminName").toString()); // admin_name
            com.setFlatName(community.get("flatName").toString()); // flat_name;
            com.setAddress(community.get("address").toString()); // address
            com.setRemark(community.get("remark").toString()); // remark
            com.setCommunityName(community.get("communityName").toString()); //community_name
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
    @PostMapping("/deletCommunity")
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
     * @param community
     * @return
     */
    @PostMapping("/updateCommunity")
    public @ResponseBody JSONObject updateCommunity(@RequestParam Map<String, Object> community){
        JSONObject r = new JSONObject();
        try {
            if (community != null){
                communityInterface.updateDevelop(
                        Integer.parseInt(community.get("id").toString()),
                        community.get("communityName").toString(),
                        community.get("address").toString(),
                        Integer.parseInt(community.get("adminId").toString()),
                        community.get("remark").toString(),
                        community.get("adminName").toString(),
                        community.get("flatName").toString());
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


}

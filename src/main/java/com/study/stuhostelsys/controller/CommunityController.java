package com.study.stuhostelsys.controller;

/**
 * 公社表
 */
import com.study.stuhostelsys.dao.CommunityInterface;
import com.study.stuhostelsys.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommunityController {

    @Autowired
    private CommunityInterface communityInterface;

    /**
     * 增加公社信息
     * @param community
     * @return
     */
    @PostMapping("/saveCommunity")
    public @ResponseBody String saveCommunity(@RequestParam Community community){
        String data = null;
        try {
            communityInterface.save(community);
            data = "0";
        } catch (Exception e) {
            e.printStackTrace();
            data = "-1";
        }
        return data;
    }

    /**
     * 删除公社信息
     * @param id
     * @return
     */
    @PostMapping("/deletCommunity")
    public @ResponseBody String deleteCommunity(@RequestParam Integer id){
        String data = null;
        try {
            if (id != null){
                communityInterface.deleteById(id);
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
     * 修改公社信息
     * @param community
     * @return
     */
    @PostMapping("/updateCommunity")
    public @ResponseBody String updateCommunity(@RequestParam Community community){
        String data = null;
        try {
            if (community != null){
                communityInterface.updateDevelop(community.getId(),
                        community.getCommunityName(),
                        community.getAddress(),
                        community.getAdminId(),
                        community.getRemark());
                data = "0";
            } else {
                data = "community不能为空！";
            }
        } catch (Exception e) {
            e.printStackTrace();
            data = "-1";
        }
        return data;
    }

    /**
     * 查看公社信息
     * @return
     */
    @PostMapping("/getCommunityList")
    public @ResponseBody List<Community> getCommunityList(){
        List<Community> communityList = new ArrayList<>();
        try {
            communityList = communityInterface.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return communityList;
    }


}

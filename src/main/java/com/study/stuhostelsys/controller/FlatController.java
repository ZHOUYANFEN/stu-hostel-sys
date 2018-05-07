package com.study.stuhostelsys.controller;

import com.study.stuhostelsys.dao.AdminInterface;
import com.study.stuhostelsys.dao.CommunityInterface;
import com.study.stuhostelsys.dao.FlatInterface;
import com.study.stuhostelsys.model.Flat;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 公寓表
 */
@RestController
public class FlatController {

    @Autowired
    private FlatInterface flatInterface;

    @Autowired
    private AdminInterface adminInterface;

    @Autowired
    private CommunityInterface communityInterface;

    @GetMapping("flat")
    public ModelAndView flat(@RequestParam("id")Integer id, Model model){
        model.addAttribute("admin", adminInterface.findAllById(id)); // 管理员
        model.addAttribute("comm", communityInterface.findAll()); // 公社公寓
        return new ModelAndView("hostel/flat");
    }

    /**
     * 增
     * @param adminId
     * @param adminName
     * @param flatName
     * @param flatNum
     * @param flatUser
     * @param flatUserId
     * @param flatUserTel
     * @param type
     * @param remark
     * @return
     */
    @PostMapping("/saveFlat")
    public @ResponseBody JSONObject saveFlat(@RequestParam String adminId,
                                             @RequestParam String adminName,
                                             @RequestParam String flatName,
                                             @RequestParam String flatNum,
                                             @RequestParam String flatUser,
                                             @RequestParam String flatUserId,
                                             @RequestParam String flatUserTel,
                                             @RequestParam String type,
                                             @RequestParam String size,
                                             @RequestParam String remark){
        JSONObject r = new JSONObject();
        Flat flat = new Flat();
        flat.setAdminId(adminId);
        flat.setAdminName(adminName);
        flat.setFlatName(flatName);
        flat.setFlatNum(flatNum);
        flat.setFlatUser(flatUser);
        flat.setFlatUserId(flatUserId);
        flat.setFlatUserTel(flatUserTel);
        flat.setType(type);
        flat.setSize(size);
        flat.setRemark(remark);

        try {
            flatInterface.save(flat);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 删
     * @param id
     * @return
     */
    @PostMapping("/deleteFlat")
    public @ResponseBody JSONObject deleteFlat(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            flatInterface.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 分组删
     * @param adminId
     * @param flatName
     * @param flatNum
     * @return
     */
    @PostMapping("/deleteFlatByAdminIdAndFlat")
    public @ResponseBody JSONObject deleteFlatByAdminIdAndFlat(@RequestParam String adminId,
                                                               @RequestParam String flatName,
                                                               @RequestParam String flatNum){
        JSONObject r = new JSONObject();
        try {
            flatInterface.deleteFlatByAdminIdAndFlat(adminId, flatName, flatNum);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 根据Id修改
     * @param id
     * @param flatName
     * @param flatNum
     * @param flatUser
     * @param flatUserId
     * @param flatUserTel
     * @param type
     * @param remark
     * @return
     */
    @PostMapping("/updateFlatById")
    public @ResponseBody JSONObject updateFlatById(@RequestParam Integer id,
                                                   @RequestParam String flatName,
                                                   @RequestParam String flatNum,
                                                   @RequestParam String flatUser,
                                                   @RequestParam String flatUserId,
                                                   @RequestParam String flatUserTel,
                                                   @RequestParam String type,
                                                   @RequestParam String size,
                                                   @RequestParam String remark){
        JSONObject r = new JSONObject();
        try {
            flatInterface.updateFlatById(id,flatName,flatNum,flatUser,flatUserId,flatUserTel,type,size,remark);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 根据AdminId查所有的flat
     * @param adminId
     * @param model
     * @return
     */
    @PostMapping("/getFlatListByAdminId")
    public @ResponseBody JSONObject getFlatListByAdminId(@RequestParam String adminId, Model model){
        List<Flat> flat = new ArrayList<>();
        JSONObject r = new JSONObject();
        try {
            flat = flatInterface.findAllByAdminId(adminId);
            r.put("data", flat);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 根据ID查
     * @param id
     * @return
     */
    @PostMapping("/findFlatById")
    public @ResponseBody JSONObject findFlatById(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        r.put("flat", flatInterface.findAllById(id));
        return r;
    }

}

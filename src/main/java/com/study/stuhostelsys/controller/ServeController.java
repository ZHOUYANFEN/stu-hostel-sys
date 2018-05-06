package com.study.stuhostelsys.controller;

/**
 * 公共服务表
 */
import com.study.stuhostelsys.dao.CommunityInterface;
import com.study.stuhostelsys.dao.ServeInterface;
import com.study.stuhostelsys.model.Serve;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServeController {

    @Autowired
    private ServeInterface serveInterface;

    @Autowired
    private CommunityInterface communityInterface;

    @GetMapping("/serve")
    public ModelAndView serve(Model model){
        ModelAndView view = new ModelAndView("hostel/serve");
        model.addAttribute("comm", communityInterface.findAll());
        return view;
    }

    /**
     * 保存Serve
     * @param flatName
     * @param flatAddress
     * @param flatUser
     * @param flatUserTel
     * @param type
     * @param time
     * @param serve
     * @param serveId
     * @param serveTel
     * @param remark
     * @return
     */
    @PostMapping("/saveServe")
    public @ResponseBody JSONObject saveServe(@RequestParam String flatName,
                         @RequestParam String flatAddress,
                         @RequestParam String flatUser,
                         @RequestParam String flatUserTel,
                         @RequestParam String type,
                         @RequestParam String time,
                         @RequestParam String serve,
                         @RequestParam String serveId,
                         @RequestParam String serveTel,
                         @RequestParam String remark){
        JSONObject r = new JSONObject();
        Serve ser = new Serve();
        ser.setFlatName(flatName);
        ser.setFlatAddress(flatAddress);
        ser.setFlatUser(flatUser);
        ser.setFlatUserTel(flatUserTel);
        ser.setType(type);
        ser.setTime(time);
        ser.setServe(serve);
        ser.setServeId(serveId);
        ser.setServeTel(serveTel);
        ser.setRemark(remark);
        try {
            serveInterface.save(ser);
            r.put("data","0");
        } catch (Exception e){
            r.put("data","-1");
            r.put("error",e);
        }
        return r;
    }

    /**
     * 查询所有
     * @param model
     * @return
     */
    @PostMapping("/getServeList")
    public @ResponseBody JSONObject getServeList(Model model){
        List<Serve> ser = new ArrayList<>();
        JSONObject r = new JSONObject();
        try {
            Sort sort = new Sort(Sort.Direction.ASC, "time");
            ser = serveInterface.findAll(sort);
            r.put("data", ser);
            model.addAttribute("model", ser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * 根据id 查询
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/findServeById")
    public @ResponseBody JSONObject findServeById(@RequestParam Integer id, Model model){
        JSONObject r = new JSONObject();
        r.put("ser",serveInterface.findAllById(id));
        model.addAttribute("ser", r);
        return r;
    }

    /**
     * 更新登记
     * @param id
     * @param flatUserTel
     * @param type
     * @param time
     * @param serve
     * @param serveId
     * @param serveTel
     * @param remark
     * @return
     */
    @PostMapping("/updateServe")
    public @ResponseBody JSONObject updateServe(@RequestParam Integer id,
                                                @RequestParam String flatUserTel,
                                                @RequestParam String type,
                                                @RequestParam String time,
                                                @RequestParam String serve,
                                                @RequestParam String serveId,
                                                @RequestParam String serveTel,
                                                @RequestParam String remark){
        JSONObject r = new JSONObject();
        try {
            serveInterface.updateServe( id,
                    flatUserTel,
                    type,
                    time,
                    serve,
                    serveId,
                    serveTel,
                    remark);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e.getMessage());
        }
        return r;
    }

    /**
     * 删除服务信息
     * @param id
     * @return
     */
    @PostMapping("/deleteServe")
    public @ResponseBody JSONObject deleteCommunity(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            if (id != null){
                serveInterface.deleteById(id);
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
}

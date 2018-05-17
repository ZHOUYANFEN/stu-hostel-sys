package com.study.stuhostelsys.controller;

import com.study.stuhostelsys.dao.AdviceInterface;
import com.study.stuhostelsys.model.Advice;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdviceController {

    @Autowired
    private AdviceInterface adviceInterface;

    @GetMapping("/advice")
    public ModelAndView advice(@RequestParam("power") String power, Model model){
        ModelAndView view;
        if (power.equals("1")) {
            view = new ModelAndView("sys_manage/advice");
        } else {
            view = new ModelAndView("hostel/advice");
            model.addAttribute("advice", getAdviceList());
        }
        return view;
    }

    /**
     * 增
     * @param title
     * @param time
     * @param content
     * @return
     */
    @PostMapping("/saveAdvice")
    @ResponseBody
    public JSONObject saveAdvice(@RequestParam String title,
                                 @RequestParam String time,
                                 @RequestParam String content){
        JSONObject r = new JSONObject();
        Advice a = new Advice();
        a.setTitle(title);
        a.setContent(content);
        a.setTime(time);
        try {
            adviceInterface.save(a);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error",e);
        }
        return r;
    }

    /**
     * 删
     * @param id
     * @return
     */
    @PostMapping("/deleteAdvice")
    @ResponseBody
    public JSONObject deleteAdvice(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            adviceInterface.deleteById(id);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data","-1");
            r.put("error",e);
        }
        return r;
    }

    /**
     * 查
     * @return
     */
    @PostMapping("/getAdviceList")
    public JSONObject getAdviceList(){
        JSONObject r = new JSONObject();
        List<Advice> a = new ArrayList<>();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "time");
            a = adviceInterface.findAll(sort);
            r.put("data", a);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error",e);
        }
        return r;
    }

    /**
     * id查
     * @return
     */
    @PostMapping("/selectAdviceById")
    @ResponseBody
    public JSONObject selectAdviceById(@RequestParam Integer id){
        JSONObject r = new JSONObject();
        try {
            r.put("data", adviceInterface.findAllById(id));
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error",e);
        }
        return r;
    }
}

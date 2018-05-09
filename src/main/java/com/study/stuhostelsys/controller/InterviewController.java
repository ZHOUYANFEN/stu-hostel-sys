package com.study.stuhostelsys.controller;

import com.study.stuhostelsys.dao.InterviewInterface;
import com.study.stuhostelsys.model.Interview;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InterviewController {

    @Autowired
    private InterviewInterface interviewInterface;

    /**
     * 跳转
     */
    @GetMapping("/interview")
    public ModelAndView interview() {
        ModelAndView view = new ModelAndView("hostel/interview");
        return view;
    }

    /**
     * 保存
     *
     * @param visit
     * @param visitId
     * @param visitTel
     * @param flatName
     * @param flatTel
     * @param flatNum
     * @param time
     * @return
     */
    @PostMapping("/saveInterview")
    @ResponseBody
    public JSONObject saveInterview(@RequestParam String visit,
                                    @RequestParam String visitId,
                                    @RequestParam String visitTel,
                                    @RequestParam String flatName,
                                    @RequestParam String flatTel,
                                    @RequestParam String flatNum,
                                    @RequestParam String time) {
        JSONObject r = new JSONObject();
        Interview i = new Interview();
        i.setVisit(visit);
        i.setVisitId(visitId);
        i.setVisitTel(visitTel);
        i.setFlatName(flatName);
        i.setFlatTel(flatTel);
        i.setFlatNum(flatNum);
        i.setTime(time);
        try {
            interviewInterface.save(i);
            r.put("data", "0");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }

    /**
     * 查
     * @return
     */
    @PostMapping("getInterviewList")
    @ResponseBody
    public JSONObject getInterviewList(){
        List<Interview> i = new ArrayList<>();
        JSONObject r = new JSONObject();
        try {
            i = interviewInterface.findAll();
            r.put("data", i);
        } catch (Exception e) {
            e.printStackTrace();
            r.put("data", "-1");
            r.put("error", e);
        }
        return r;
    }
}

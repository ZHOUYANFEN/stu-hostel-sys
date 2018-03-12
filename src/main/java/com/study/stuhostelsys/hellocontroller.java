package com.study.stuhostelsys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 */

// @RestController： 代表是一个controller，可以接收前台发送的请求，对数据进行处理
@RestController
public class hellocontroller {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String say() {
        return "Hello Word !";
    }
}

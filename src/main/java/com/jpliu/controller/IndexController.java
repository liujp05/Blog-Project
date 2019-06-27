package com.jpliu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("title", "Hello Freemarker");
        return "index";
    }
}

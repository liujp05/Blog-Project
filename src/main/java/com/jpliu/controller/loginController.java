package com.jpliu.controller;


import com.jpliu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class loginController {

    private static final Logger logger = LoggerFactory.getLogger(loginController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public String reg(Model model,
                      @RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam(value = "next", required = false) String next,
                      HttpServletResponse response) {

        try {
            Map<String, String> map = userService.register(username, password);
        } catch (Exception e) {//如果注册出现问题 就跳回登录注册页面
            logger.error("注册异常" + e.getMessage());
            return "login";
        }
        return "login";
    }
}

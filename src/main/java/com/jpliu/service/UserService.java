package com.jpliu.service;

import com.jpliu.common.LoginStatus;
import com.jpliu.component.utils.MD5Util;
import com.jpliu.component.utils.StringUtils;
import com.jpliu.dao.loginTicketMapper;
import com.jpliu.dao.userMapper;
import com.jpliu.model.loginTicket;
import com.jpliu.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private userMapper userMapper;

    @Autowired
    private loginTicketMapper loginTicketMapper;



    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    public Map<String, String> register(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();

        //判断用户名
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        //判断密码
        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        //判断用户名是否存在
        user user = userMapper.selectByName(username);
        if (user != null) {
            map.put("msg", "用户名已经被注册");
            return map;
        }

        //可以增加其他安全检查 长度敏感词过滤等

        //开始对user表添加用户
        user = new user();
        user.setName(username);
        /**
         * 处理密码
         */

        //为密码添加盐
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        //随机添加一个头像
        user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(100)));
        //最终添加密码
        user.setPassword(MD5Util.MD5(password + user.getSalt()));

        //添加用户
        userMapper.insert(user);

        return map;
    }

    //这个函数的功能是增加一个ticket
    public String addLoginTicket(int userId) {
        loginTicket loginTicket = new loginTicket();
        loginTicket.setUserId(userId);
        Date now = new Date();

        //一个小时3600 秒， 一天24小时， 2 天有效期
        now.setTime(3600 * 24 * 100 + now.getTime());
        loginTicket.setExpired(now);
        loginTicket.setStatus(LoginStatus.VALID.getStatus());
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketMapper.insert(loginTicket);

        return loginTicket.getTicket();
    }

    public void logout(String ticket) {
        loginTicketMapper.updateStatus(ticket, LoginStatus.INVALID.getStatus());
    }
}

package com.hx.springbt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Login Controller
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
public class LoginController {


    /**
     * 登录
     *
     * @return the string
     * @author : yangjunqing / 2018-05-28
     */
    @RequestMapping("/customLogin")
    public String customLogin(){
        return "login";
    }

    /**
     * 主页
     *
     * @return the string
     * @author : yangjunqing / 2018-05-28
     */
    @RequestMapping("/")
    public String home(){
        return "home";
    }

}

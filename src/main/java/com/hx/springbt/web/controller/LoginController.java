package com.hx.springbt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping("/customLogin")
    public String customLogin(){
        return "login";
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

}

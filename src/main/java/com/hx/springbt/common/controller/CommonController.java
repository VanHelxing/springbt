package com.hx.springbt.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
public class CommonController {


    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("name", "luvletter");
        return "home";
    }
}

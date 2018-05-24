package com.hx.springbt.common.controller;

import com.hx.springbt.common.util.http.ServletUtils;
import com.hx.springbt.security.entity.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
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

        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("name", user.getUsername());
        return "home";
    }
}

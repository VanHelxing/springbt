package com.hx.springbt.common.controller.system.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
@RequestMapping("/system/security/user")
public class UserController {


    /**
     * 用户主页
     * @param model
     * @return
     */
    @GetMapping("")
    public String list(Model model){
        return "system/security/user";
    }
}

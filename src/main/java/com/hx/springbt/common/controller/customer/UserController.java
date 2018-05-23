package com.hx.springbt.common.controller.customer;

import com.hx.springbt.common.entity.customer.User;
import com.hx.springbt.common.service.customer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
@RequestMapping("/base/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询所有的用户信息
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

}

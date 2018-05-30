package com.hx.springbt.security.controller;

import com.hx.springbt.common.util.http.ServletUtils;
import com.hx.springbt.common.util.json.JsonUtils;
import com.hx.springbt.common.util.page.PageUtils;
import com.hx.springbt.core.constant.Constraints;
import com.hx.springbt.core.entity.PageParam;
import com.hx.springbt.core.entity.ResponseData;
import com.hx.springbt.core.entity.SearchParam;
import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.security.service.SysUserService;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "用户管理")
@Controller
@RequestMapping("/system/security/user")
public class UserController {

    @Resource
    private SysUserService sysUserService;


    /**
     * 列表查询
     * @param pageParam
     * @param request
     * @param model
     * @return
     */
    @GetMapping("")
    public String list(PageParam pageParam, HttpServletRequest request, Model model){
        List<SearchParam> searchParams = ServletUtils.getSearchParam(request);
        Page<SysUser> page = sysUserService.search(searchParams, pageParam);
        ResponseData data = PageUtils.getResponseData(page);
        model.addAttribute(Constraints.RESPONSE_DATA, JsonUtils.objectToJson(data));

        return "/system/security/user/list";
    }

}

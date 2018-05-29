package com.hx.springbt.security.controller;

import com.hx.springbt.common.util.http.ServletUtils;
import com.hx.springbt.common.util.page.PageUtils;
import com.hx.springbt.common.util.security.EncryptUtils;
import com.hx.springbt.core.entity.PageParam;
import com.hx.springbt.core.entity.ResponseData;
import com.hx.springbt.core.entity.SearchParam;
import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.security.service.SysUserService;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "用户管理")
@Controller
@RequestMapping("/system/security/user")
public class UserController {

    @Resource
    private SysUserService sysUserService;


    @ApiOperation(value = "获取用户列表", notes = "分页查询用户信息")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "userName", value = "用户姓名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "tel", value = "用户电话", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "当前页面", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面显示条数(默认50条)", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "direction", value = "排序方向(ASC or DESC)", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sorts", value = "排序的列名", required = false, dataType = "String[]"),
    })
    @GetMapping("/findAllWithPage.json")
    @ResponseBody
    public ResponseData findAllWithPage(String userName, String tel, @ApiIgnore PageParam pageParam, HttpServletRequest request){
        List<SearchParam> searchParams = ServletUtils.getSearchParam(request);
        Page<SysUser> page = sysUserService.search(searchParams, pageParam);
        ResponseData data = PageUtils.getResponseData(page);
        return data;
    }


    @ApiOperation(value = "保存用户", notes = "新增或者更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user实体类", dataType = "SysUser")
    })
    @GetMapping("/save.json")
    @ResponseBody
    public ResponseData save(SysUser user){
        user.setPassword(EncryptUtils.BCrypt(user.getPassword()));
        SysUser sysUser = sysUserService.save(user);
        return ResponseData.ok(sysUser);
    }
}

package com.hx.springbt.security.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hx.springbt.common.util.http.ServletUtils;
import com.hx.springbt.common.util.json.JsonUtils;
import com.hx.springbt.common.util.lang.StringUtils;
import com.hx.springbt.common.util.page.PageUtils;
import com.hx.springbt.core.constant.Constraints;
import com.hx.springbt.core.entity.PageInfo;
import com.hx.springbt.core.entity.ResponseData;
import com.hx.springbt.core.entity.ResponsePage;
import com.hx.springbt.core.entity.SearchParam;
import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.security.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * 系统用户页面
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
@RequestMapping("/system/security")
public class UserController {

    @Resource
    private SysUserService sysUserService;


    /**
     * 用户页面
     *
     * @param model the model
     * @return the string
     * @author : yangjunqing / 2018-05-25
     */
    @GetMapping("/user")
    public String list(Model model) throws JsonProcessingException {
        Page<SysUser> page = sysUserService.search(null, new PageInfo());
//        model.addAttribute(Constraints.PAGE_DATA, PageUtils.getResponsePage(page));
        try {
            model.addAttribute(Constraints.PAGE_DATA, JsonUtils.objectToJson(PageUtils.getResponsePage(page)));
        } catch (JsonProcessingException e) {
            model.addAttribute(Constraints.PAGE_DATA, JsonUtils.objectToJson(ResponseData.fail("解析Json发生了错误！")));
        }
        return "system/security/user/list";
    }


    /**
     * 分页查询
     *
     * @param pageInfo the page info
     * @param request  the request
     * @return the response page
     * @author : yangjunqing / 2018-05-25
     */
    @GetMapping("/search.json")
    @ResponseBody
    public ResponsePage search(PageInfo pageInfo, HttpServletRequest request){
        List<SearchParam> searchParams = ServletUtils.getSearchParam(request);
        Page<SysUser> page = sysUserService.search(searchParams, pageInfo);

        return PageUtils.getResponsePage(page);
    }


}

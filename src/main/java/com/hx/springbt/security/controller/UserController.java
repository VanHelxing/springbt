package com.hx.springbt.security.controller;

import com.hx.springbt.common.util.lang.StringUtils;
import com.hx.springbt.common.util.page.PageUtils;
import com.hx.springbt.core.entity.PageInfo;
import com.hx.springbt.core.entity.ResponsePage;
import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.security.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/security")
public class UserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/test")
    public String test(){
        return "访问成功";
    }


//    @GetMapping("/search")
//    public Map<String, Object> search(String userName, String tel, int pageNum, int pageSize, String sortType){
//
//        Pageable pageable = PageUtils.buildPageRequest(pageNum, pageSize, sortType);
//
//        Page<SysUser> page = sysUserService.findAll(new Specification<SysUser>() {
//            @Override
//            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                List<Predicate> predicates = new ArrayList<>();
//
//                if (!StringUtils.isEmpty(userName)){
//                    predicates.add(builder.like(root.get("userName").as(String.class), "%" + userName + "%"));
//                }
//
//                if (!StringUtils.isEmpty(tel)){
//                    predicates.add(builder.like(root.get("tel").as(String.class), "%" + tel + "%"));
//                }
//
//                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
//            }
//        }, pageable);
//
//        return PageUtils.getPageMap(page);
//    }

    @GetMapping("/search")
    public ResponsePage search(String userName, String tel, PageInfo pageInfo){
        Pageable pageable = PageUtils.buildPageRequest(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getSort(), pageInfo.getDirection());

        Page<SysUser> page = sysUserService.findAll(new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(userName)){
                    predicates.add(builder.like(root.get("userName").as(String.class), "%" + userName + "%"));
                }

                if (!StringUtils.isEmpty(tel)){
                    predicates.add(builder.like(root.get("tel").as(String.class), "%" + tel + "%"));
                }

                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);

        return PageUtils.getResponsePage(page);
    }

}

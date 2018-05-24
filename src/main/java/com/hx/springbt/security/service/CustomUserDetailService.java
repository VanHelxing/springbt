package com.hx.springbt.security.service;

import com.hx.springbt.security.entity.SecurityUser;
import com.hx.springbt.security.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findByUserName(userName);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户名【"+ userName +"】没有找到!");
        }

        SecurityUser securityUser = new SecurityUser(sysUser);
        return  securityUser;
    }
}

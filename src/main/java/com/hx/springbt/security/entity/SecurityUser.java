package com.hx.springbt.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SecurityUser extends SysUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    public SecurityUser(SysUser sysUser) {
        if (sysUser != null){
            this.setId(sysUser.getId());
            this.setUserName(sysUser.getUserName());
            this.setPassword(sysUser.getPassword());
            this.setOrgId(sysUser.getOrgId());
            this.setEmail(sysUser.getEmail());
            this.setTel(sysUser.getTel());
            this.setUserRoles(sysUser.getUserRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysUserRole> userRoles = this.getUserRoles();

        if (userRoles != null && userRoles.size() != 0){
            for (SysUserRole userRole : userRoles){
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getSysRole().getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    /**
     * 密码
     */
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

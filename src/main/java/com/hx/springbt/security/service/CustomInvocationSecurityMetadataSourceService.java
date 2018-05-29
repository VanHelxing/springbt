package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysResourceDao;
import com.hx.springbt.security.entity.SysResource;
import com.hx.springbt.security.entity.SysRole;
import com.hx.springbt.security.entity.SysRoleResource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 加载资源信息
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Resource
    private SysResourceDao sysResourceDao;

    /** 权限信息 (key - url, value - roles) */
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    /**
     * 加载数据库中所有的资源信息
     */
    private void loadResources(){
        List<SysResource> resources = sysResourceDao.findAll();
        if (resources != null && resources.size() > 0){
            resourceMap = new HashMap<>();
            for (SysResource resource : resources){
                Collection<SysRoleResource> roleResources = resource.getRoleResources();
                if (roleResources != null && roleResources.size() > 0){
                    Collection<ConfigAttribute> roles = new ArrayList<ConfigAttribute>();
                    for (SysRoleResource roleResource : roleResources){
                        SecurityConfig config = new SecurityConfig(roleResource.getSysRole().getRoleName());
                        roles.add(config);
                    }
                    resourceMap.put(resource.getMethodpath(), roles);
                }
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (resourceMap == null){
            loadResources();
        }

        HttpServletRequest request = (HttpServletRequest) object;
        for (Iterator<String> ite = resourceMap.keySet().iterator(); ite.hasNext();){
            String resUrl = ite.next();
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)){
                return resourceMap.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

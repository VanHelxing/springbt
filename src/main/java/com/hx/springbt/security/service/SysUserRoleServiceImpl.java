package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysUserRoleDao;
import com.hx.springbt.security.entity.SysUserRole;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements SysUserRoleService {

    @Resource
    private SysUserRoleDao sysUserRoleDao;


    @Override
    protected BaseDao<SysUserRole> getRepository() {
        return sysUserRoleDao;
    }
}

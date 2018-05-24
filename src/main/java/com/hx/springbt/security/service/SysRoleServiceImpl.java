package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysRoleDao;
import com.hx.springbt.security.entity.SysRole;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Resource
    private SysRoleDao sysRoleDao;


    @Override
    protected BaseDao<SysRole> getRepository() {
        return sysRoleDao;
    }
}

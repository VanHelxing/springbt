package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysRoleResourceDao;
import com.hx.springbt.security.entity.SysRoleResource;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class SysRoleResourceServiceImpl extends BaseServiceImpl<SysRoleResource> implements SysRoleResourceService {

    @Resource
   private SysRoleResourceDao sysRoleResourceDao;


    @Override
    protected BaseDao<SysRoleResource> getRepository() {
        return sysRoleResourceDao;
    }
}

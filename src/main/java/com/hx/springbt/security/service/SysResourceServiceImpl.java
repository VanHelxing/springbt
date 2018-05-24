package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysResourceDao;
import com.hx.springbt.security.entity.SysResource;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements SysResourceService {

    @Resource
    private SysResourceDao sysResourceDao;


    @Override
    protected BaseDao<SysResource> getRepository() {
        return sysResourceDao;
    }
}

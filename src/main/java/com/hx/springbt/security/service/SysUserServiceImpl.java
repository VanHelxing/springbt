package com.hx.springbt.security.service;

import com.hx.springbt.security.dao.SysUserDao;
import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    protected BaseDao<SysUser> getRepository() {
        return sysUserDao;
    }


    /**
     * 通过用户名查询信息
     *
     * @param userName 用户名
     * @return the sys user
     * @author : yangjunqing / 2018-05-24
     */
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserDao.findByUserName(userName);
    }
}

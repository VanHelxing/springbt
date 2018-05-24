package com.hx.springbt.security.service;

import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.core.service.BaseService;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface SysUserService extends BaseService<SysUser> {


    /**
     * 通过用户名查询信息
     *
     * @param userName 用户名
     * @return the sys user
     * @author : yangjunqing / 2018-05-24
     */
    public SysUser findByUserName(String userName);
}

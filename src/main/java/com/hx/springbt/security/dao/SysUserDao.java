package com.hx.springbt.security.dao;

import com.hx.springbt.security.entity.SysUser;
import com.hx.springbt.core.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Repository
public interface SysUserDao extends BaseDao<SysUser> {


    /** 通过用户名查询用户信息 */
    public SysUser findByUserName(String userName);
}

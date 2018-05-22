package com.hx.springbt.common.service;

import com.hx.springbt.common.dao.UserDao;
import com.hx.springbt.common.entity.User;
import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户Service实现类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    protected BaseDao<User> getRepository() {
        return userDao;
    }
}

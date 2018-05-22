package com.hx.springbt.common.dao;

import com.hx.springbt.common.entity.User;
import com.hx.springbt.core.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Repository
public interface UserDao extends BaseDao<User> {

}

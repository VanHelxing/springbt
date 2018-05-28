package com.hx.springbt.web.service;

import com.hx.springbt.core.dao.BaseDao;
import com.hx.springbt.core.service.BaseServiceImpl;
import com.hx.springbt.web.dao.SystemLogDao;
import com.hx.springbt.web.entity.SystemLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日志实现类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service("systemLogService")
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogDao systemLogDao;


    @Override
    protected BaseDao<SystemLog> getRepository() {
        return systemLogDao;
    }
}

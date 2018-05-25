package com.hx.springbt.web.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 日志拦截器
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class LogInterceptor implements HandlerInterceptor {

    private static Logger log = LogManager.getLogger(LogInterceptor.class);

    private static PathMatcher matcher = new AntPathMatcher();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("日志拦截器有请求进入，路径为: " + request.getRequestURI());

        String[] filterpath = {"", ""};


        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("请求完成...");
    }
}

package com.hx.springbt.web.interceptor;

import com.hx.springbt.common.util.http.AppContextUtils;
import com.hx.springbt.common.util.http.ServletUtils;
import com.hx.springbt.common.util.json.JsonUtils;
import com.hx.springbt.web.entity.SystemLog;
import com.hx.springbt.web.service.SystemLogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
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

    /** 请求开始时间 */
    private static final String BEGIN_TIME = "begin_time";
    /** 系统日志 */
    private static final String SYSTEM_LOG = "system_log";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("日志拦截器有请求进入，路径为: " + request.getRequestURI());

        long beginTime = System.currentTimeMillis();
        SystemLog systemLog = new SystemLog();

        String requestType;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String requestParams = JsonUtils.objectToJson(request.getParameterMap());

        if (ServletUtils.isRestRequest(request)){
            requestType = "api";
        } else {
          requestType = "system";
        }

        systemLog.setRequestType(requestType);
        systemLog.setRequestUri(request.getRequestURI());
        systemLog.setRequestMethod(handlerMethod.getMethod().getName());
        systemLog.setRequestParam(requestParams);
        systemLog.setRequestAddr(request.getRemoteAddr());

        request.setAttribute(SYSTEM_LOG, systemLog);
        request.setAttribute(BEGIN_TIME, beginTime);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("请求完成...");

        long endTime = System.currentTimeMillis();
        SystemLogService systemLogService = AppContextUtils.getBean("systemLogService");
        long beginTime = (long) request.getAttribute(BEGIN_TIME);
        SystemLog systemLog = (SystemLog) request.getAttribute(SYSTEM_LOG);

        systemLog.setHandleTime(String.valueOf((endTime - beginTime) / 1000));
        systemLog.setResponseStatus(String.valueOf(response.getStatus()));

        systemLogService.save(systemLog);
    }
}

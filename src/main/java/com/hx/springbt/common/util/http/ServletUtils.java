package com.hx.springbt.common.util.http;

import com.hx.springbt.common.util.lang.StringUtils;
import com.hx.springbt.core.entity.SearchParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/** Http工具类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class ServletUtils {

    /**
     * 返回当前请求对象
     *
     * @return the http servlet request
     * @author : yangjunqing / 2018-05-21
     */
    public static HttpServletRequest getRequest(){
        HttpServletRequest request = null;
        request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request == null){
            return null;
        }
        return request;
    }

    /**
     * 返回当前响应对象
     *
     * @return the http servlet response
     * @author : yangjunqing / 2018-05-21
     */
    public static HttpServletResponse getResponse(){
        HttpServletResponse response = null;
        response = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
        if(response == null){
            return null;
        }
        return response;
    }

    /**
     * 返回当前sessionId
     *
     * @return the string
     * @author : yangjunqing / 2018-05-21
     */
    public static String getSessionId(){
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        if (StringUtils.isEmpty(sessionId)){
            return null;
        }
        return sessionId;
    }

    /**
     * 是否是不返回视图的请求
     *
     * @param request the request
     * @return the boolean
     * @author : yangjunqing / 2018-05-21
     */
    public static boolean isRestRequest(HttpServletRequest request){
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1){
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1){
            return true;
        }

        String uri = request.getRequestURI();
        if (StringUtils.inStringIgnoreCase(uri, ".json", ".xml")){
            return true;
        }

        String ajax = request.getParameter("__ajax");
        if (StringUtils.inStringIgnoreCase(ajax, "json", "xml")){
            return true;
        }

        return false;
    }

    public static List<SearchParam> getSearchParam(HttpServletRequest request){
        List<SearchParam> searchParams = new ArrayList<>();

        Enumeration<String> keys = request.getParameterNames();
        for (Enumeration<String> e = keys; keys.hasMoreElements();){
            String key = keys.nextElement().toString();
            if ("pageNum".equals(key) || "pageSize".equals(key) || "sort".equals(key) || "direction".equals(key)){
                continue;
            }
            SearchParam param = new SearchParam();
            param.setColumnName(key);
            param.setClazz(request.getParameter(key).getClass());
            param.setColumnValue(request.getParameter(key));
            searchParams.add(param);
        }

        return searchParams;
    }

}

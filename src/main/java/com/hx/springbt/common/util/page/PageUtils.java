package com.hx.springbt.common.util.page;

import com.hx.springbt.common.util.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页数据工具类
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class PageUtils {

    /**
     * 封装分页数据到Map中
     *
     * @param objPage the obj page
     * @return the map
     * @author : yangjunqing / 2018-05-24
     */
    public static Map<String, Object> getPageMap(Page<?> objPage){
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("page_data", objPage.getContent());
        resultMap.put("total_num", objPage.getTotalElements());
        resultMap.put("total_page", objPage.getTotalPages());
        resultMap.put("page_num", objPage.getNumber());
        resultMap.put("page_size", objPage.getSize());
        return resultMap;
    }

    /**
     * 创建分页请求。
     *
     * @param pageNum   当前页
     * @param pageSize  每页条数
     * @param sortType  排序字段
     * @param direction 排序方向
     * @return the page request
     * @author : yangjunqing / 2018-05-24
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType, String direction) {
        Sort sort = null;

        if (StringUtils.isEmpty(sortType)) {
            return new PageRequest(pageNum - 1, pageSize);
        } else if (!StringUtils.isEmpty(direction)) {
            if (Direction.ASC.equals(direction)) {
                sort = new Sort(Direction.ASC, sortType);
            } else {
                sort = new Sort(Direction.DESC, sortType);
            }
            return new PageRequest(pageNum - 1, pageSize, sort);
        } else {
            sort = new Sort(Direction.ASC, sortType);
            return new PageRequest(pageNum - 1, pageSize, sort);
        }
    }

    /**
     * 创建分页请求(该方法可以放到util类中).
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType) {
        return buildPageRequest(pageNum, pageSize, sortType, null);
    }

    /**
     * 创建分页请求
     *
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize, Sort sort) {
        return new PageRequest(pageNum - 1, pageSize, sort);
    }

    /**
     * 创建分页请求(该方法可以放到util类中).
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize) {
        return buildPageRequest(pageNum, pageSize, null, null);
    }
}

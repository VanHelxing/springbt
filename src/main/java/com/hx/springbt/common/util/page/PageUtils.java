package com.hx.springbt.common.util.page;

import com.hx.springbt.common.util.lang.StringUtils;
import com.hx.springbt.core.constant.Constraints;
import com.hx.springbt.core.entity.PageInfo;
import com.hx.springbt.core.entity.ResponsePage;
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
     * Page数据封装到统一格式中返回
     * @param page
     * @return
     */
    public static ResponsePage getResponsePage(Page<?> page){
        Map<String, Object> pageInfo = new HashMap<>();

        pageInfo.put(Constraints.TOTAL_NUM, page.getTotalElements());
        pageInfo.put(Constraints.TOTAL_PAGE, page.getTotalPages());
        pageInfo.put(Constraints.PAGE_NUM, page.getNumber() + 1);
        pageInfo.put(Constraints.PAGE_SIZE, page.getSize());
        return ResponsePage.ok(page.getContent(), pageInfo);
    }

    /**
     * 创建分页请求
     * @param info
     * @return
     */
    public static PageRequest buildPageRequest(PageInfo info){
        return buildPageRequest(info.getPageNum(), info.getPageSize(), info.getSort(), info.getDirection());
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

        if (StringUtils.isEmpty(direction)) {
            return PageRequest.of(pageNum - 1, pageSize);
        }
        else if (!StringUtils.isEmpty(direction)) {
            if (Direction.ASC.equals(direction)) {
                sort = new Sort(Direction.ASC, sortType);
            } else {
                sort = new Sort(Direction.DESC, sortType);
            }
            return PageRequest.of(pageNum - 1, pageSize);
        }
        else {
            sort = new Sort(Direction.ASC, sortType);
            return PageRequest.of(pageNum - 1, pageSize, sort);
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
        return PageRequest.of(pageNum - 1, pageSize, sort);
    }

    /**
     * 创建分页请求(该方法可以放到util类中).
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize) {
        return buildPageRequest(pageNum, pageSize, null, null);
    }
}

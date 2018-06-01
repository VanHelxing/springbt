package com.hx.springbt.common.util.page;

import com.hx.springbt.core.constant.Constraints;
import com.hx.springbt.core.entity.PageData;
import com.hx.springbt.core.entity.PageParam;
import com.hx.springbt.core.entity.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页数据工具类
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class PageUtils {


    /**
     * 将查询出的Page信息统一封装至ResponseData
     * @param page
     * @return
     */
    public static ResponseData getResponseData(Page<?> page){
        Map<String, Object> pageInfo = new HashMap<>();
        PageData pageData = new PageData();

        pageInfo.put(Constraints.TOTAL_NUM, page.getTotalElements());
        pageInfo.put(Constraints.TOTAL_PAGE, page.getTotalPages());
        pageInfo.put(Constraints.PAGE_NUM, page.getNumber() + 1);
        pageInfo.put(Constraints.PAGE_SIZE, page.getSize());

        pageData.setData(page.getContent());
        pageData.setPageInfo(pageInfo);

        return ResponseData.ok(pageData);
    }

    /**
     * 创建分页请求
     * @param pageNum
     * @param pageSize
     * @param direction
     * @param columns
     * @return
     */
    public static PageRequest buildPageRequest(int pageNum, int pageSize, String direction, List<String> columns){
        Sort sort = null;

        if (columns == null || columns.size() == 0){
            return PageRequest.of(pageNum - 1, pageSize);
        }
        else {
            if (Direction.ASC.equals(direction)){
                sort = new Sort(Direction.ASC, columns);
            }else {
                sort = new Sort(Direction.DESC, columns);
            }
            return PageRequest.of(pageNum - 1, pageSize, sort);
        }
    }

    /**
     * 创建分页请求
     * @param pageParam
     * @return
     */
    public static PageRequest buildPageRequest(PageParam pageParam){
        return buildPageRequest(pageParam.getPageNum(), pageParam.getPageSize(), pageParam.getDirection(), pageParam.getSorts());
    }

}

package com.hx.springbt.common.util.auto;

/**
 * 代码自动生成器
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class AutoCreateCodeUtils {

    //公共部分
    private static final String RT_1 = "\r\n";
    private static final String RT_2 = RT_1 + RT_1;
    private static final String BLANK_1 = " ";
    private static final String BLANK_4 = "    ";
    private static final String BLANK_8 = BLANK_4 + BLANK_4;

    //注释部分
    private static final String ANNOTATION_AUTHOR_PARAMTER = "@author ";
    private static final String ANNOTATION_AUTHOR_NAME = "yangjunqing / yangjunqing@zhimadi.cn";
    private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
    private static final String ANNOTATION_DATE = "@date ";
    private static final String ANNOTATION = "/**"+RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_AUTHOR +RT_1+BLANK_1+"*"+BLANK_1+ANNOTATION_DATE +"getDate()"+RT_1+BLANK_1+"*/"+RT_1;

    //生成的文件地址
    private static final String DAO_PATH = "com/hx/springbt";
    private static final String SERVICE_PATH = "com/hx/springbt";
    private static final String SERVICE_IMPL_PATH = "com/hx/springbt";

    //包名
    private static final String ENTITY_URL = "com.hx.springbt.core.entity";
    private static final String DAO_URL = "com.hx.springbt.core.dao";
    private static final String SERVICE_URL = "com.hx.springbt.core.service";
    private static final String SERVICE_IMPL_URL = "com.hx.springbt.core.service";

    //基本类
    private static final String BASE_DAO_NAME = DAO_URL + ".BaseDao";
    private static final String BASE_SERVICE_NAME = SERVICE_URL + ".BaseService";
    private static final String BASE_SERVICE_IMPL_NAME = SERVICE_IMPL_URL + ".BaseServiceImpl";



}

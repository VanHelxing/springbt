package com.hx.springbt.common.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json 常用工具类
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class JsonUtils {

    /**
     * objectMapper
     */
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Json utils.
     */
    private JsonUtils(){}

    /**
     * Get instance object mapper.
     */
    public static ObjectMapper getInstance(){
        return objectMapper;
    }

    /**
     * Object to json string.
     */
    public static String objectToJson(Object obj) {
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * Json to pojo t.
     *
     * @param <T>     the type parameter
     * @param jsonStr the json str
     * @param clazz   the clazz
     * @return the t
     * @author : yangjunqing / 2018-05-25
     */
    public static <T> T jsonToPojo(String jsonStr, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * json string convert to map
     *
     * @param <T>     the type parameter
     * @param jsonStr the json str
     * @return the map
     * @author : yangjunqing / 2018-05-25
     */
    public static <T> Map<String, Object> json2map(String jsonStr) {
        Map<String, Object> objectMap = null;
        try {
            objectMap = objectMapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectMap;
    }

    /**
     * json string convert to map with javaBean
     *
     * @param <T>     the type parameter
     * @param jsonStr the json str
     * @param clazz   the clazz
     * @return the map
     * @throws Exception the exception
     * @author : yangjunqing / 2018-05-25
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     *
     * @param <T>          the type parameter
     * @param jsonArrayStr the json array str
     * @param clazz        the clazz
     * @return the list
     * @throws Exception the exception
     * @author : yangjunqing / 2018-05-25
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     *
     * @param <T>   the type parameter
     * @param map   the map
     * @param clazz the clazz
     * @return the t
     * @author : yangjunqing / 2018-05-25
     */
    public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}

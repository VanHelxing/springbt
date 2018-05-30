package com.hx.springbt.common.util.auto;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码自动生成器
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class AutoCreateCodeUtils {


    public static void main(String[] args) throws IOException, TemplateException {

//        Configuration configuration = new Configuration();
//        Template template = null;
//https://blog.csdn.net/sz_bdqn/article/details/11376063
        Map<String, String> root = new HashMap<>();
        root.put("entity_name", "DictHead");

        String fileName = "D:\\myworkspace\\springbt\\src\\main\\resources\\freemarker\\test.java";
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }

//        File t = new File("classpath:freemarker");
//        if (!t.exists()){
//            System.out.println("t不存在");
//            t.mkdir();
//        }
//
//        configuration.setDirectoryForTemplateLoading(t);


//        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

    }

}

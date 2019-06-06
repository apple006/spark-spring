package com.dr.leo.demo.service;

import com.dr.leo.demo.util.ScalaTestUtil;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通过scala的静态类访问，Scala中的方法
 * @author longping.jie (weixiao.me@aliyun.com)
 * @version 1.0
 * @website https://www.jlpyyf.com
 * @date 2019/6/6 13:47
 * @since 1.0
 */
@Service
public class JavaTestService {
    @Autowired
    private SparkSession sparkSession;

    public String readTable(String tableName) {
        return WordCountServiceObject.readDimShop(sparkSession, tableName);
    }

    public String sayHello() {
        //调用scala util
        System.out.println(ScalaTestUtil.sayHello());
        return "JavaTestService sayHello";
    }
}

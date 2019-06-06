package com.dr.leo.demo.service;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longping.jie (weixiao.me@aliyun.com)
 * @version 1.0
 * @website https://www.jlpyyf.com
 * @date 2019/6/6 13:47
 * @since 1.0
 */
@Service
public class JtestService {
    @Autowired
    private SparkSession sparkSession;

    public String readTable() {
        return TestService.readDimShop(sparkSession);
    }

    public String readTable2() {
        return "readTable2";
    }
}

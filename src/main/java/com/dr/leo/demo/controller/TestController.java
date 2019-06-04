package com.dr.leo.demo.controller;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leo.jie
 * @date 2019-06-04 20:20
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private HiveContext hc;

    @RequestMapping("/word")
    public String wordCount() {
        Dataset<Row> df = hc.sql("select count(*) from ba_model.dim_shop");
        List<Long> result = df.javaRDD().map((Function<Row, Long>) row -> row.getLong(0)).collect();
        hc.sql("select * from ba_model.dim_shop").show(10);
        return result.get(0).toString();
    }
}

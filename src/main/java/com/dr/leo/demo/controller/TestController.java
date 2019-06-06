package com.dr.leo.demo.controller;

import com.dr.leo.demo.service.JtestService;
import com.dr.leo.demo.service.TestService2;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leo.jie
 * @date 2019-06-04 20:20
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private JtestService jTestService;
    @Autowired
    private SparkSession sparkSession;
    @Autowired
    private TestService2 testService2;

    @RequestMapping("/findShop")
    public String wordCount() {
        return jTestService.readTable();
    }

    @RequestMapping("/findShop2")
    public String findShop() {
        return testService2.readDimShop(sparkSession);
    }
}

package com.dr.leo.demo.controller;

import com.dr.leo.demo.service.JavaTestService;
import com.dr.leo.demo.service.WordCountService;
import com.dr.leo.demo.service.WordCountServiceClass;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author leo.jie
 * @date 2019-06-04 20:20
 */
@RestController
@RequestMapping("/test")
public class WordCountController {
    @Autowired
    private JavaTestService javaTestService;
    @Autowired
    private SparkSession sparkSession;
    @Autowired
    private WordCountServiceClass wordCountServiceClass;
    @Autowired
    private WordCountService wordCountService;

    @RequestMapping("/wordCount")
    public Map<String, Integer> wordCount(@RequestParam String filePath) {
        Tuple2<String, Object>[] res = wordCountServiceClass.wordCount(sparkSession, filePath);
        return Arrays.stream(res).collect(Collectors.toMap(word -> word._1,
                word -> Integer.parseInt(word._2.toString())));
    }

    @RequestMapping("/readTable")
    public String[] readTableOfHive(@RequestParam String tableName) {
        return wordCountServiceClass.readTableOfHive(sparkSession, tableName);
    }

    @GetMapping("/test/readTable")
    public String wordCountServiceClassTest(@RequestParam String tableName) {
        return wordCountServiceClass.test(tableName);
    }

    @GetMapping("/java/readTable")
    public String javaReadTableOfHive(@RequestParam String tableName) {
        return javaTestService.readTable(tableName);
    }

    @GetMapping("/test/readTableNoSparkSession")
    public String[] readTableNoSparkSession(@RequestParam String tableName) {
        return wordCountService.readTableOfHive(tableName);
    }
}

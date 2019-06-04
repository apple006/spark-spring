package com.dr.leo.demo.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.hive.HiveContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leo.jie
 * @date 2019-06-04 20:19
 */
@Configuration
public class SparkContextBean {
    private String appName = "sparkExp";

    private String master = "local[2]";

    @Bean
    @ConditionalOnMissingBean(SparkConf.class)
    public SparkConf sparkConf() throws Exception {
        SparkConf conf = new SparkConf().setAppName(appName);
        //.setMaster(master);
        return conf;
    }

    @Bean
    @ConditionalOnMissingBean(JavaSparkContext.class)
    public JavaSparkContext javaSparkContext() throws Exception {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    @ConditionalOnMissingBean(HiveContext.class)
    public HiveContext hiveContext() throws Exception {
        return new HiveContext(javaSparkContext());
    }
}

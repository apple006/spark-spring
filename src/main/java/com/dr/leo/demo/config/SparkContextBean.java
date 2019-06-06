package com.dr.leo.demo.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leo.jie
 * @date 2019-06-04 20:19
 */
@Configuration
public class SparkContextBean {
  /*  private String appName = "sparkExp";

    private String master = "local[2]";*/

    @Bean
    @ConditionalOnMissingBean(SparkSession.class)
    public SparkSession sparkSession() throws Exception {
        return SparkSession.builder()
                .appName("FastKettle")
                //.master("local[20]")
                .enableHiveSupport()
                .getOrCreate();
    }
/*
    @Bean
    @ConditionalOnMissingBean(JavaSparkContext.class)
    public JavaSparkContext javaSparkContext() throws Exception {
        return new JavaSparkContext(sparkConf());
    }

    @Bean
    @ConditionalOnMissingBean(HiveContext.class)
    public HiveContext hiveContext() throws Exception {
        return new HiveContext(javaSparkContext());
    }*/
}

package com.dr.leo.demo.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 管理spark session
 * @author leo.jie
 * @date 2019-06-04 20:19
 */
@Configuration
public class SparkContextBean {
    @Bean
    @ConditionalOnMissingBean(SparkSession.class)
    public SparkSession sparkSession() throws Exception {
        return SparkSession.builder()
                .appName("FastKettle")
                //.master("local[4]")
                .enableHiveSupport()
                .getOrCreate();
    }
}

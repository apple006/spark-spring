package com.dr.leo.demo.service

import org.apache.spark.sql.SparkSession

object WordCountServiceObject {
  def readDimShop(sparkSession: SparkSession,tableName:String): String = {
    //仅仅为了测试操作hive中的一张表
    sparkSession.table(tableName).show(10)
    "success"
  }
}

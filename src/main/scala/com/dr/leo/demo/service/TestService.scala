package com.dr.leo.demo.service

import org.apache.spark.sql.SparkSession

object TestService {
  def readDimShop(sparkSession: SparkSession): String = {
    sparkSession.table("ba_model.dim_shop").show(10)
    "success"
  }
}

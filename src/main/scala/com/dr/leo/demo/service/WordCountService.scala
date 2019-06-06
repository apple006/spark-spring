package com.dr.leo.demo.service

import org.apache.spark.sql.{Row, SparkSession}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WordCountService {
  @Autowired
  private val sparkSession: SparkSession = null

  def readTableOfHive(tableName: String): Array[String] = {
    val df = sparkSession.table(tableName)
    df.show(10)
    df.toJSON.collect()
  }

}

package com.dr.leo.demo.service

import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WordCountServiceClass {
  @Autowired
  private val javaTestService: JavaTestService = null

  def wordCount(sparkSession: SparkSession, textFilePath: String): Array[(String, Int)] = {
    val line = sparkSession.sparkContext.textFile(textFilePath)
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect()
  }

  def readTableOfHive(sparkSession: SparkSession, tableName: String): Array[String] = {
    val df = sparkSession.table(tableName).limit(10)
    df.show(10)
    df.toJSON.collect()
  }

  def test(tableName: String): String = {
    //调用java service 中的方法
    javaTestService.readTable(tableName)
    javaTestService.sayHello()
  }
}

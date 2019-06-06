package com.dr.leo.demo.service

import com.dr.leo.demo.util.TestUtil
import org.apache.spark.sql.SparkSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService2 {
  @Autowired
  private val jtestService: JtestService = null

  def readDimShop(sparkSession: SparkSession): String = {
    sparkSession.table("ba_model.dim_shop").show(10)
    val testUtil: TestUtil = new TestUtil()
    "success " + TestUtil.hello2() + " " + testUtil.hello() + " " + jtestService.readTable2()
  }
}

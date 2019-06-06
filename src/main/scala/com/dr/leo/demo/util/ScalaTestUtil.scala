package com.dr.leo.demo.util

object ScalaTestUtil {
  def sayHello(): String = {
    println(JavaTestUtil.hello2())
    val javaTestUtil: JavaTestUtil = new JavaTestUtil
    println(javaTestUtil.hello())
    "hello,I am scala sayHello!"
  }
}

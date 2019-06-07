 
<p align="center"> 在Java的世界里，最不缺乏的就是想象力！当<b>Spark</b>遇上<b>Spring Boot</b>，又会发生怎样的故事呢！😋</p>

<p align="center">基于 <code>Java8</code> + <code>Scala</code> + <code>Spark</code>+<code>Spring Boot</code> 充分利用起SpringBoot注解开发的便利，IOC等等Bean对象管理的优势，构建定制化Spark任务管理服务。😋</p>

<p align="center">起一个常驻集群的<b>Spark+SpringBoot</b> 服务，以API的方式，手动或定时触发我们的Spark任务，避免繁琐冗长的Submit命令，避免一次又一次的资源申请，实时监控任务运行，及时得到运行反馈。使非开发人员，点点拽拽，也可以运行我们的日常业务，操作我们的大数据平台。😋</p>

<p align="center">
    <b>github  </b> <b> <a href="https://github.com/CCweixiao/spark-spring">https://github.com/CCweixiao/spark-spring</a></b>
</p>
 <p align="center">
    <b>技术栈  </b> <b> <a href="https://www.jlpyyf.com">介龙平博客 | 一个程序员的个人博客</a></b>
</p>

 <p align="center">
    <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img src="https://img.shields.io/badge/JDK-1.8-green.svg"></a>
    <a href="https://spring.io/projects/spring-boot/"><img src="https://img.shields.io/badge/SpringBoot-1.5.6-green.svg"></a>
    <a href="http://maven.apache.org/"><img src="https://img.shields.io/badge/Maven-3.6.1-green.svg"></a>
    <a href="http://spark.apache.org/"><img src="https://img.shields.io/badge/Spark-2.4.3-green.svg"></a>
    <a href="https://www.scala-lang.org/"><img src="https://img.shields.io/badge/Scala-2.11.8-green.svg"></a>
    <a href="http://hive.apache.org/"><img src="https://img.shields.io/badge/Hive-3.1.1-green.svg"></a>
      <a href="http://hadoop.apache.org/"><img src="https://img.shields.io/badge/Hadoop-2.7.4-green.svg"></a>
</p>

***

- [**`功能特性`**](#功能特性)
- [**`我的环境`**](#我的环境)
  - [**`开发环境`**](#开发环境)
  - [**`测试集群环境`**](#测试集群环境)
  - [**`测试集群配置`**](#测试集群配置)
- [**`项目结构`**](#项目结构)
- [**`技术栈`**](#技术栈)
- [**`开始使用`**](#开始使用)
- [**`运行测试`**](#运行测试)
- [**`总结`**](#总结)

# 功能特性

* [x] Spark与SpringBoot集成，解决了冲突依赖
* [x] Spring Bean对象池集中管理SparkSession对象
* [x] 依赖注入Scala类
* [x] java与Scala代码互相调用
* [x] maven混合java Scala编译打包
* [x] spark-submit提交，常驻集群，API方式，运行spark任务

# 我的环境

## 开发环境

- MacOs 10.14.5
- jdk 1.8
- scala 2.11.8
- spark 2.4.3
- idea 2019.1.2

## 测试集群环境

- centos7
- jdk1.8
- scala 2.11.8
- hadoop 2.7.4
- spark 2.4.3
- hive 3.1.1

## 测试集群配置

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo21559835384_.pic.jpg)

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo31559835573_.pic.jpg)


# 项目结构

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo20190606232643.png)


# 技术栈
- jdk 1.8
- maven 3.6.1
- SpringBoot 1.5.6
- spark 2.4.3
- hive 3.4.1
- ...

# 开始使用

1. 使用IDE导入本项目,更新pom,导入依赖
2. 替换集群配置文件为自己的
3. mvn clean package 打包

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo20190606234118.png)


```java
//集群运行时注意修改
@Bean
    @ConditionalOnMissingBean(SparkSession.class)
    public SparkSession sparkSession() throws Exception {
        return SparkSession.builder()
                .appName("FastKettle")
                //.master("local[4]")
                .enableHiveSupport()
                .getOrCreate();
    }
```
4. 提交集群运行

<code> spark-submit --class com.dr.leo.demo.SparkSpringApplication --executor-memory 4G --num-executors 4 --master yarn --deploy-mode client spark-spring-0.0.1-SNAPSHOT.jar </code>

# 运行测试

服务启动后如图

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo51559835979_.pic_hd.jpg)

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo61559836034_.pic_hd.jpg)

postman 测试

WordCount

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo11559836383_.pic.jpg)

操作hive中的表

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo21559836459_.pic_hd.jpg)

java scala互相调用

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo31559836510_.pic.jpg)

依赖注入

![](https://leo-jie-pic.oss-cn-beijing.aliyuncs.com/picgo-leo41559836583_.pic_hd.jpg)

# 总结

以上操作便完成了SpringBoot与Spark的整合，如有不妥之处，还望指正。

Spark与Spring Boot的整合，结合两者的优点，具体可以发挥怎样的效果，还需要结合公司业务或自己的需求，自由想象。

整合过程中遇到的最大问题，其实是SpringBoot与集群之间的包冲突。经过反复测试，比较兼容的一个SpringBoot版本是1.5.6。2.0以上版本的未经严格测试，依赖包冲突的貌似比较多，或需要排更多的依赖包。
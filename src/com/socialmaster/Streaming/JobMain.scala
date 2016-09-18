package com.socialmaster.Streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds

/**
 * Spark Streaming example
 */
object JobMain {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    // 从SparkConf创建StreamingContext并制定1秒钟的批处理大小
    val ssc = new StreamingContext(conf, Seconds(1))
    // 连接到本地机器7777端口上后，使用接收到的数据创建DStream
    val lines = ssc.socketTextStream("localhost", 7777)
    // 从DStream中筛选出包含字符串"error"的行
    val errorLines = lines.filter {_.contains("error")}
    // 打印出有"error"的行
    errorLines.print()

    // 启动流计算环境StreamingContext并等待它完成
    ssc.start()
    // 等待作业完成
    ssc.awaitTermination()
  }
}
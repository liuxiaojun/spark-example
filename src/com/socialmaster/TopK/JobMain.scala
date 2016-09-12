package com.socialmaster.TopK

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * TopK (这个地方统计top5的例子)
 */
object JobMain {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val line = sc.textFile("/user/bigdata/input/test.txt")
    val result = line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_)
    val sorted = result.map{case(key,value) => (value,key)}.sortByKey(true,1)
    val topk = sorted.top(3)
    topk.foreach(println)
  }
}
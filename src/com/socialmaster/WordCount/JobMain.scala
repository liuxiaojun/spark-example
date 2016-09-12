package com.socialmaster.WordCount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * WordCount
 */
object JobMain {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val line = sc.textFile("/user/bigdata/input/test.txt")
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
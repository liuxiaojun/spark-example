package com.socialmaster.Median

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * 中位数
 */
object JobMain {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val rdd=sc.makeRDD(Array(1,8,6,4,9,3,76,4))
    //RDD[Int]=(1,3,4,4,6,8,9,76)
    val sorted = rdd.sortBy(identity).zipWithIndex().map {
      case (v, idx) => (idx, v)
    }
    //(1,1)，(2,3)，(3,4)，(4,4)，(5,6)，(6,8)，(7,9)，(8,76)
    
    val count = sorted.count() 
    val median: Double = if (count % 2 == 0) {
      val l = count / 2 - 1
      val r = l + 1
      (sorted.lookup(l).head + sorted.lookup(r).head).toDouble / 2
    
    } else sorted.lookup(count / 2).head.toDouble
    println(median)
  }
}
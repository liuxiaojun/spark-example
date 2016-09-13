package com.socialmaster.Accumulator

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/*
 * 累加器
 */
object JobMain {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val file = sc.textFile("/user/bigdata/input/test.txt")

    val blankLines = sc.accumulator(0)
    val callSigns = file.flatMap( line => {
      if (line == "") {
        blankLines += 1
      }
      line.split(" ")
    })
    
    callSigns.saveAsTextFile("output.txt")
    println("Blank lines: " + blankLines.value)
  }
}
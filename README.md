# spark-example

##wordcount
* 准备
HDFS集群上文件/user/bigdata/input/test.txt内容为 a b c d a b c a b a
* 运行方式 sh run.sh
```
spark-submit \
--class "com.socialmaster.WordCount.JobMain" \
--master yarn-client \
--executor-memory 1G \
--num-executors 1 \
--executor-cores 1 \
spark-example.jar
```

##TopK
* 准备
HDFS集群上文件/user/bigdata/input/test.txt内容为 a b c d a b c a b a
* 运行方式 sh run.sh
```
spark-submit \
--class "com.socialmaster.TopK.JobMain" \
--master yarn-client \
--executor-memory 1G \
--num-executors 1 \
--executor-cores 1 \
spark-example.jar
```

##中位数 Median
* 运行方式 sh run.sh
```
spark-submit \
--class "com.socialmaster.Median.JobMain" \
--master yarn-client \
--executor-memory 1G \
--num-executors 1 \
--executor-cores 1 \
spark-example.jar
```
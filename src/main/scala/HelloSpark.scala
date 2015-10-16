/**
 * Created by snudurupati on 10/16/15.
 * This is a sample template to show how to create an individual module
 */
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.log4j.{Level, Logger}

object HelloSpark {
  def main (args: Array[String]) {
    //The silence of the Logs (pun intended :)
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    //Create Spark Context
    val conf = new SparkConf().setAppName("HelloSpark")
      .setMaster("local")
    val sc = new SparkContext(conf)

    //Data Analytics code
    val lines = sc.textFile("data/NEWS.txt")
    val wordCount = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    wordCount.cache()

    //print output
    println("Total words in the document: %d".format(wordCount.count()))
    wordCount.take(25).foreach(println)

    //stop Spark context
    sc.stop()

  }

}

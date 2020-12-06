
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import scala.collection.mutable.ListBuffer

package com.microsoft.tsi
class Connector {
  def getDataFrame(spark: SparkSession): DataFrame = {
    import spark.implicits._
    val r = scala.util.Random
    var temp: Double = 42.0
    val ts_id: String= "my_id"
    var lst = new ListBuffer[(String, Int, Double)]
    for (i <- 0 until 100) {
      temp += (r.nextDouble - 0.5)
      val t = (ts_id, i, temp)
      lst += t
    }
    return lst.toDF("ts_id", "timestamp", "temp")

  }
}
import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {

  def main(args: Array[String]): Unit = {
    val logFile = sys.env("SPARK_HOME") + "/README.md"
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}

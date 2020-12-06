from py4j.java_gateway import java_import
from pyspark.sql import DataFrame, SQLContext


def test_smoke(spark):
    sc = spark.sparkContext
    java_import(sc._gateway.jvm, "com.microsoft.tsi.*")
    connector = sc._gateway.jvm.Connector()
    jdf = connector.getDataFrame(spark._jsparkSession)
    df = DataFrame(jdf, SQLContext(sc))
    assert df.count() == 100

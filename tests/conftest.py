from pyspark.sql import SparkSession
import pytest


@pytest.fixture
def spark():
    spark = (
        SparkSession.builder.master("spark://master:7077")
        .appName("test")
        .config("spark.jars", "/tsi/target/scala-2.12/tsi_2.12-0.1.0.jar")
        .getOrCreate()
    )
    yield spark
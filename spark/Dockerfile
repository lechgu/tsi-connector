FROM openjdk:8-jdk-slim-buster
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y python3.7 python3-pip python3-venv wget vim dos2unix && \
    apt-get autoremove && \
    python3 -m venv /venv

RUN wget https://archive.apache.org/dist/hadoop/common/hadoop-2.7.7/hadoop-2.7.7.tar.gz && \
    tar -xzf hadoop-2.7.7.tar.gz && \
    mv hadoop-2.7.7 /hadoop && \
    rm hadoop-2.7.7.tar.gz

RUN wget https://archive.apache.org/dist/spark/spark-3.0.1/spark-3.0.1-bin-without-hadoop.tgz && \
    tar -xzf spark-3.0.1-bin-without-hadoop.tgz && \
    mv spark-3.0.1-bin-without-hadoop /spark && \
    rm spark-3.0.1-bin-without-hadoop.tgz

COPY core-site.xml hadoop-env.sh /hadoop/etc/hadoop/

COPY requirements.txt spark.sh jupyter.sh /

RUN dos2unix /spark.sh && \
    chmod +x /spark.sh && \
    dos2unix /jupyter.sh && \
    chmod +x /jupyter.sh

RUN /venv/bin/pip install -r /requirements.txt

ENV HADOOP_HOME="/hadoop"
ENV SPARK_HOME="/spark"

ENV SPARK_DIST_CLASSPATH="/hadoop/etc/hadoop:/hadoop/share/hadoop/common/lib/*:/hadoop/share/hadoop/common/*:/hadoop/share/hadoop/hdfs:/hadoop/share/hadoop/hdfs/lib/*:/hadoop/share/hadoop/hdfs/*:/hadoop/share/hadoop/yarn/lib/*:/hadoop/share/hadoop/yarn/*:/hadoop/share/hadoop/mapreduce/lib/*:/hadoop/share/hadoop/mapreduce/*:/hadoop/contrib/capacity-scheduler/*.jar:/hadoop/share/hadoop/tools/lib/hadoop-azure-2.7.7.jar:/hadoop/share/hadoop/tools/lib/azure-storage-2.0.0.jar"

ENV PATH="/venv/bin:${HADOOP_HOME}/bin:${SPARK_HOME}/bin:${PATH}"
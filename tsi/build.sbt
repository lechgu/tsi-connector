ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.microsoft"
ThisBuild / organizationName := "Microsoft"

lazy val tsi = (project in file("."))
  .settings(
    name := "tsi",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
  )
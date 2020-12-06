import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.microsoft"
ThisBuild / organizationName := "Microsoft"

lazy val root = (project in file("."))
  .settings(
    name := "tsi",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.0.1"
)
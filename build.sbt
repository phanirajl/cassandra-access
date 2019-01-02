name := "cassandra-access"

organization := "one.observatory"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.8"

scalacOptions ++= Seq("-feature",
                      "-unchecked",
                      "-deprecation",
                      "-Ywarn-value-discard")

licenses := Seq(
  "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

lazy val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "com.outworkers"  %% "phantom-dsl" % "2.31.0",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
)

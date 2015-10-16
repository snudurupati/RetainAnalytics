name := "RetainAnalytics"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.1",
  "org.apache.spark" %% "spark-sql" % "1.4.1",
  "org.apache.spark" %% "spark-mllib" % "1.4.1",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.4.1",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.4.0-M3"
)

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"
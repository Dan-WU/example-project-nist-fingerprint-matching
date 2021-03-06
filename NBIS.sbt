name := "NBIS"
version := "1.0"
scalaVersion := "2.10.6"

resolvers ++= Seq(
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases"
)

// packages to exclude from sbt-assembly's fat jar
val jettyOrg = ExclusionRule(organization = "org.mortbay.jetty")
val sparkOrg = ExclusionRule(organization = "org.apache.spark")


libraryDependencies += "org.scala-lang.modules" %% "scala-pickling" % "0.10.1"
libraryDependencies ++= Seq(
  "org.apache.hbase" % "hbase-client" % "1.2.0",
  "org.apache.hbase" % "hbase-common" % "1.2.0",
  "org.apache.spark" %% "spark-core" % "1.6.0" % "provided",
  "it.nerdammer.bigdata" % "spark-hbase-connector_2.10" % "1.0.3"
    excludeAll(
      jettyOrg,
      sparkOrg
    ),
  "commons-io" % "commons-io" % "2.4"
)

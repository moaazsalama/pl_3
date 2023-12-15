ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

val AkkaVersion = "2.9.0"
lazy val root = (project in file("."))
  .settings(
    name := "pl_3",
      libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "ch.qos.logback" % "logback-classic" % "1.2.6",
        "mysql" % "mysql-connector-java" % "8.0.23"


      )


  )
resolvers += "Akka library repository".at("https://repo.akka.io/maven")


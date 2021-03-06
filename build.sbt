ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "dev.nomadblacky"
ThisBuild / organizationName := "NomadBlacky"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / resolvers ++= Seq(
  Resolver.bintrayRepo("digdag", "maven")
)

lazy val root = (project in file("."))
  .aggregate(notification)

lazy val notification = (project in file("notification"))
  .settings(
    name := "digdag-extension-example-notification",
    libraryDependencies ++= Seq(
        "io.digdag"     % "digdag-spi" % "0.9.42" % Provided,
        "org.scalatest" %% "scalatest" % "3.0.8"  % Test
      )
  )

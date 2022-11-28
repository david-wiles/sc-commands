ThisBuild / version := "0.1.1-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

enablePlugins(ScalaNativePlugin)

lazy val root = (project in file("."))
  .settings(
    organization := "net.davidwiles",
    name := "commands",
    idePackagePrefix := Some("net.davidwiles.commands")
  )

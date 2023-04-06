ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "scala-3-new-features"
  )

lazy val scala3 = (project in file("scala-3"))
  .settings(
    name := "scala-3-new-features"
  )

lazy val zioPlayground = (project in file("zio-playground"))
  .settings(
    name := "scala-3-new-features"
  )

lazy val playground = (project in file("playground"))
  .settings(
    name := "scala-3-new-features"
  )

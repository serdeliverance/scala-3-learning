ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.2.2"

lazy val zioVersion = "2.0.12"

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
    name := "scala-3-new-features",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-test" % zioVersion,
      "dev.zio" %% "zio-test-sbt" % zioVersion,
      "dev.zio" %% "zio-streams" % zioVersion,
      "dev.zio" %% "zio-test-junit" % zioVersion
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )

lazy val playground = (project in file("playground"))
  .settings(
    name := "scala-3-new-features"
  )

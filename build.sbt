lazy val root =
  Project("printf-ext", file("."))
    .settings(
      organization := "com.github.reikje",
      name := "printf-ext",
      version := "1.0.0-SNAPSHOT",
      scalaVersion := "2.11.8",
      description := "Extended printf support for Scala",
      libraryDependencies ++= Seq(
      ) ++ Seq(
        "org.scalatest" %% "scalatest" % "2.2.6"
      )
    )


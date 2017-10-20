lazy val root =
  Project("printf-ext", file("."))
    .settings(
      organization := "com.github.reikje",
      name := "printf-ext",
      version := "1.0.1",
      scalaVersion := "2.12.3",
      crossScalaVersions := Seq("2.11.11"),
      description := "Extended printf support for Scala",
      libraryDependencies ++= Seq(
      ) ++ Seq(
        "org.scalatest" %% "scalatest" % "3.0.4"
      ),
      publishTo := Some(
        if (isSnapshot.value)
          Opts.resolver.sonatypeSnapshots
        else
          Opts.resolver.sonatypeStaging
      )
    )


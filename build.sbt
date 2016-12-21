lazy val root =
  Project("printf-ext", file("."))
    .settings(
      organization := "com.github.reikje",
      name := "printf-ext",
      version := "1.0.0",
      scalaVersion := "2.11.8",
      description := "Extended printf support for Scala",
      libraryDependencies ++= Seq(
      ) ++ Seq(
        "org.scalatest" %% "scalatest" % "2.2.6"
      ),
      pomExtra in Global := {
        <url>(your project URL)</url>
          <licenses>
            <license>
              <name>Apache 2</name>
              <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            </license>
          </licenses>
          <scm>
            <connection>scm:git:git://github.com/reikje/printf-ext.git</connection>
            <developerConnection>scm:git:git@github.com:reikje/printf-ext.git</developerConnection>
            <url>github.com/reikje/printf-ext</url>
          </scm>
          <developers>
            <developer>
              <id>reikje</id>
              <name>Reik Schatz</name>
              <url>https://github.com/reikje</url>
            </developer>
          </developers>
      }
    )


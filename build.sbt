enablePlugins(ScalaJSPlugin)

name := "cesiummil"

organization := "com.github.workingDog"

scalaJSStage in Global := FastOptStage

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.1")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.github.workingDog" %%% "cesiumscala" % "1.6",
  "com.github.workingDog" %%% "scalams" % "1.0.0"
)

jsDependencies += RuntimeDOM

skip in packageJSDependencies := false

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xlint" // Enable recommended additional warnings.
)

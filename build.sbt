enablePlugins(ScalaJSPlugin)

name := "cesiummil"

organization := "com.github.workingDog"

scalaJSStage in Global := FastOptStage

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.github.workingDog" %%% "cesiumscala" % "1.2",
  "com.github.workingDog" %%% "scalams" % "0.1-SNAPSHOT"
)

jsDependencies += RuntimeDOM

skip in packageJSDependencies := false

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xlint" // Enable recommended additional warnings.
)

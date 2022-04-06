ThisBuild / organization := "io.github.siculo"
ThisBuild / organizationName := "SBT BOM"
ThisBuild / version := "0.3.0"
ThisBuild / scalaVersion := "2.12.8"
ThisBuild / homepage := Project.homepage
ThisBuild / developers := Project.developers
ThisBuild / licenses := Project.licenses
ThisBuild / scmInfo := Project.scmInfo

lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "sbt-bom",
    sbtPlugin := true,
    libraryDependencies ++= Dependencies.library,
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-Dplugin.version=" + version.value, "-Dplugin.organization=" + organization.value)
    },
    scriptedBufferLog := false,
    dependencyOverrides += "org.typelevel" %% "jawn-parser" % "0.14.1"
  )

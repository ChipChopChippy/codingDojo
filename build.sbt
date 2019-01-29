import Dependencies.{scalaTest, _}
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

name := "codingDojo"
libraryDependencies += scalaTest % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
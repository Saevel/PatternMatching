name := """PatternMatching"""

version := "1.0"

scalaVersion := "2.11.6"

scalaSource in Test := baseDirectory.value / "src/test/scala"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq("org.scalacheck" % "scalacheck_2.11" % "1.12.3" % "test")

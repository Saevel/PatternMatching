name := """PatternMatching"""

version := "1.0"

scalaVersion := "2.11.6"

scalaSource in Test := baseDirectory.value / "src/test/scala"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq("org.scalacheck" % "scalacheck_2.11" % "1.12.3" % "test")

//Aliases
addCommandAlias("taskOne", "testOnly org.jug.patternmatching.task1.TaskOneSpec")

addCommandAlias("taskTwo", "testOnly org.jug.patternmatching.task2.TaskTwoSpec")

addCommandAlias("taskThree", "testOnly org.jug.patternmatching.task3.TaskThreeSpec")

addCommandAlias("taskFour", "testOnly org.jug.patternmatching.task4.TaskFourSpec")

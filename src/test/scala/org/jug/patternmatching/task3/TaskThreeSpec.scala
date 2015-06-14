package org.jug.patternmatching.task3

import org.scalacheck._

import org.scalacheck.Prop._

import org.jug.patternmatching.task3.{Success, Failed}

/**
 * Created by Zielony on 13.06.15.
 */
object TaskThreeSpec extends Properties("Task Three - Console App"){

  val versionCommand = Gen.const(("version", None))

  val compileOrTestCommand = Gen.oneOf( ("compile", true), ("compile", false), ("test", true),
    ("test", false))

  property("testOrCompile") = forAll(compileOrTestCommand) {(data:Tuple2[String, Boolean]) =>
    consoleApp(data) == (if(data._2)Success else Failed)
  }

  property("version") = forAll(versionCommand){(data:Tuple2[String, Any]) =>
    consoleApp(data) == 1.0
  }
}

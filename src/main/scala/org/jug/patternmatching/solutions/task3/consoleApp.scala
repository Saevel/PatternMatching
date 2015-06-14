package org.jug.patternmatching.solutions.task3

import org.jug.patternmatching.task3.{Failed, Success}

/**
 * Created by Zielony on 12.06.15.
 */
object consoleApp extends (Tuple2[String, Any] => Any){

  def apply(params:Tuple2[String, Any]):Any = params match {
      case ("version", _) => 1.0
      case ("compile", true) => Success
      case ("compile", false) => Failed
      case ("test", true) => Success
      case ("test", false) => Failed
      case _ => None
  }
}

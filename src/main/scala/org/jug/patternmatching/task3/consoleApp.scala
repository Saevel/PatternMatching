package org.jug.patternmatching.task3

/**
 * Created by Zielony on 12.06.15.
 */

case object Success;
case object Failed;

object consoleApp extends (Tuple2[String, Any] => Any){

  def apply(params:Tuple2[String, Any]):Any = ???
}

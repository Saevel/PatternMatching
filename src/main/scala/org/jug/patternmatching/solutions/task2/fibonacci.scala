package org.jug.patternmatching.solutions.task2

/**
 * Created by Zielony on 12.06.15.
 */
object fibonacci extends (Int => Int) {

  def apply(n:Int):Int = n match {
      case 0 => 1
      case 1 => 2
      case _ => (fibonacci(n-1)+fibonacci(n-2))
  }
}

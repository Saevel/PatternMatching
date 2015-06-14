package org.jug.patternmatching.solutions.task1

import org.jug.patternmatching.task1.{ImpairNumber, PairNumber, NumberParity}


/**
 * Created by Zielony on 12.06.15.
 */
object parityCheck extends (Int => NumberParity) {

  def apply(n:Int):NumberParity = (n%2) match {
      case 0 => PairNumber
      case _ => ImpairNumber
  }
}

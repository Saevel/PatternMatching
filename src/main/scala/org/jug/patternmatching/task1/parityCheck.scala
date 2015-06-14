package org.jug.patternmatching.task1

case class NumberParity();
object PairNumber extends NumberParity;
object ImpairNumber extends NumberParity;

/**
 * Created by Zielony on 12.06.15.
 */
object parityCheck extends (Int => NumberParity) {

  def apply(n:Int):NumberParity = ???
}

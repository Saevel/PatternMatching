package org.jug.patternmatching.task2

import org.jug.patternmatching.task2.fibonacci
import org.scalacheck.Prop._
import org.scalacheck._

/**
 * Created by Zielony on 12.06.15.
 */
object TaskTwoSpec extends Properties("TaskTwo - Fibonacci") {

  val smallIntBiggerThanTwo = Gen.choose(2, 10);

  val one = Gen.const(0);

  val two = Gen.const(1);

  property("first") = forAll(one){(n) => fibonacci(n) == 1}

  property("second") = forAll(two){(n) => fibonacci(n) == 2}

  property("recursive") = forAll(smallIntBiggerThanTwo){(n) => (fibonacci(n) == (fibonacci(n-1) + fibonacci(n-2)))}
}
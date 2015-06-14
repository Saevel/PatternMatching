package org.jug.patternmatching.task1

import org.jug.patternmatching.task1.PairNumber

import org.scalacheck._

import org.scalacheck

import org.scalacheck.Prop._

import org.scalacheck.Prop.BooleanOperators

/**
 * Created by Zielony on 12.06.15.
 */
object TaskOneSpec extends Properties("TaskOne - Parity Check") {

  val isPair = forAll{(n:Int) => (n%2==0)}

  val returnPair = forAll{(n:Int) => parityCheck(n)==PairNumber}

  val isImpair = forAll{(n:Int) => (n%2==1) }

  val returnImpair = forAll{(n:Int) => parityCheck(n)==ImpairNumber}

  property("parity") = isPair ==> returnPair

  property("imparity") = isImpair ==> returnImpair
}
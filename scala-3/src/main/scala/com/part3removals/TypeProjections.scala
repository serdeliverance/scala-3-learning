package com.part3removals

object TypeProjections:

  class Outer:
    class Inner

  val o1 = new Outer
  val o2 = new Outer
  val i1: Outer#Inner = new o1.Inner
  val i2: Outer#Inner = new o2.Inner
  //      ^^^^^^^^^^^ type projection

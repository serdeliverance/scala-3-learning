package com.part1changes

object Extensions:

  /** Exercises:
    *
    *   1. replace an implicit class with an extension clause
    *
    * 2. Add extension methods for a binary tree
    *
    *   - map(f: A => B): Tree[B]
    *   - forAll(predicate: A => Boolean): Boolean
    *   - sum => sum all of the elements of a Integer tree
    */
  implicit class PrimerChecker(n: Int) {
    def isPrimeHelper(potDivisor: Int): Boolean =
      if (potDivisor > n / 2) true
      else if (n % potDivisor == 0) false
      else isPrimeHelper(potDivisor + 1)

    assert(n >= 0)
    if (n == 0 || n == 1) true
    else isPrimeHelper(2)
  }

  object Ex1:
    extension (n: Int)
      def isPrime(): Boolean =
        def isPrimeHelper(potDivisor: Int): Boolean =
          if (potDivisor > n / 2) true
          else if (n % potDivisor == 0) false
          else isPrimeHelper(potDivisor + 1)

      assert(n >= 0)
      if (n == 0 || n == 1) true
      else isPrimeHelper(2)

  sealed abstract trait Tree[A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

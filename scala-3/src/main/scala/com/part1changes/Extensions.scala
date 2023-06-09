package com.part1changes

import scala.annotation.tailrec

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

  object Ex2:
    sealed abstract trait Tree[A]
    case class Leaf[A](value: A) extends Tree[A]
    case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

    extension [A](tree: Tree[A])
      def map[B](f: A => B): Tree[B] =
        tree match
          case Leaf(value) => Leaf(f(value))
          case Branch(left, right) =>
            Branch(left.map(f), right.map(f))

      def forall(predicate: A => Boolean): Boolean =
        tree match
          case Leaf(value) => predicate(value)
          case Branch(left, right) =>
            left.forall(predicate) && right.forall(predicate)

    extension (tree: Tree[Int])
      def sum: Int =
        tree match
          case Leaf(value)         => value
          case Branch(left, right) => left.sum + right.sum

  @main def main() =
    import Ex1._
    import Ex2._

    val result = 8.isPrime()
    println(result)

    val tree = Branch(Branch(Leaf(28), Leaf(12)), Leaf(3))
    val result2 = tree.map(_ * 2)
    println(result2)

    val result3 = tree.forall(_ % 2 == 0)
    println(s"forall: $result3")

    val result4 = tree.sum
    println(s"sum: $result4")

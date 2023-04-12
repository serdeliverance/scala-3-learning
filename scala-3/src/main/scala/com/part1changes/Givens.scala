package com.part1changes

object Givens:

  case class Person(name: String, age: Int)

  val people =
    List(
      Person("daniel", 25),
      Person("martin", 62),
      Person("Mirta", 99)
    )

    //    Scala 2 version
    //   implicit val personOrdering: Ordering[Person] =
    //     new Ordering[Person] {
    //       override def compare(x: Person, y: Person): Int =
    //         x.name.compareTo(y.name)
    //     }

  // Scala 3: given value <=> implicit value
  given personOrdering: Ordering[Person] with
    override def compare(x: Person, y: Person): Int =
      x.name.compareTo(y.name)

  people.sorted

  // implicit arguments <=> using clauses
  // Scala 2
  def aMethodWithOrdering(persons: List[Person])(implicit
      ordering: Ordering[Person]
  ): List[Person] =
    persons.sorted

  // Scala 3
  def aMethodWithOrdering_v2(persons: List[Person])(using
      ordering: Ordering[Person]
  ): List[Person] =
    persons.sorted

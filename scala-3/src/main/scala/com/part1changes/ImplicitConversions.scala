package com.part1changes

object ImplicitConversions:

  class Person(name: String):
    def greet: String = s"Hi, $name"

  // Scala 2
  //   implicit def string2Person(string: String): Person =
  //     new Person(string)

  //   // implicit convertions
  //   val pepe: Person = "pepe" // string2Person("pepe")
  //   "Maluma".greet // string2Person("Maluma").greet

  import scala.language.implicitConversions

  given string2Person: Conversion[String, Person] with
    override def apply(string: String): Person =
      new Person(string)

  def main(args: Array[String]): Unit =
    println("sergio".greet)

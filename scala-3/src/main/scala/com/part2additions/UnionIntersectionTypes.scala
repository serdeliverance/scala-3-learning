package com.part2additions

object UnionIntersectionTypes:

  // union types
  val truth: Boolean | Int = 42

  def ambivalentMethod(arg: String | Int): String = arg match
    case _: String => "a string"
    case _: Int    => "a number"

  val aNumberDescription = ambivalentMethod(55)
  val aStringDescription = ambivalentMethod("Scala")

  // type interference wil do LCA of the branches
  val stringOrInt = if (42 > 0) "a String" else 42

  val stringOrInt_v2: String | Int = if (42 > 0) "a String" else 42

  // "flow" typing - explicit null checking
  type Maybe[T] = T | Null
  def handleMaybe(someValue: Maybe[String]): Int =
    if (someValue != null) someValue.length
    else 0

  // flow typing is restricture
  //   type ErrorOr[T] = T | "error"
  //   def handleErrorOr(someValue: ErrorOr[Int]): Unit =
  //     if (someValue != "error") println(someValue + 1)
  //     else println("error")

  // intersection types
  class Animal
  trait Carnivore
  class Crocodile extends Animal with Carnivore

  val carnivoreAnimal: Animal & Carnivore = new Crocodile

package com.part2additions

object InfixNotation:

  class Person(name: String):
    def likes(movie: String): String =
      s"$name likes $movie"

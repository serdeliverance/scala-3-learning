object Playground:

  def maximum[T](xs: List[T])(using ordering: Ordering[T]): T =
    xs.reduceLeft((x, y) => if ordering.compare(x, y) < 0 then y else x)

  @main def main(): Unit =
    val nums = List(1, 57, 2, 7, 5, 101, 22)
    val result = maximum(nums)
    println(result)

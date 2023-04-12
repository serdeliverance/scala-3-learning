object Syntax:

  // personal note: scala 2 code is compatible with scala 3

  // Scala 2 style
  val ifExpression = if (2 > 3) "bigger" else "smaller"

  // Scala 3
  val ifExpression_v2 = if 2 > 3 then "bigger" else "smaller"

  val ifExpression_v3 =
    if (2 > 3) {
      val result = "code"
      // code
      result
    } else {
      val result = "other result"
      // code
      result
    }

  // Scala 3: braceless
  val ifExpression_v4 =
    if 2 > 3 then
      val result = "code"
      // code
      result
    else
      val result = "smaller"
      // code
      result
    // identation matters

  val whileExpression: Unit = while (2 > 3) {
    println("some sentence")
    println("another sentence")
  }

  val whileExpression_v2: Unit = while 2 > 3 do
    println("some expression")
    println("another expression")
    // identation matters

  // for-comprehension
  val forComprehension =
    for {
      num <- List(1, 2, 3)
      char <- List('a', 'b')
    } yield s"$num-$char"

  val forComprehension_v2 =
    for
      num <- List(1, 2, 3)
      char <- List('a', 'b')
    yield s"$num-$char"

  val meaningOfLife = 42
  val aPatterMatch = meaningOfLife match
    case 1 => "the one"
    case 2 => "2"
    case _ => "something else"

  // try-catch
  val tryCatch =
    try {
      "".charAt(0) // throws IOOB
    } catch {
      case oobE: IndexOutOfBoundsException => '-'
      case e: Exception                    => 'z'
    }

  // Scala 3 braceless
  val tryCatch_v2 =
    try "".charAt(2)
    catch
      case oobE: IndexOutOfBoundsException => '-'
      case e: Exception                    => 'z'

  def isPrime(n: Int): Boolean =
    def aux(potentialDivisor: Int): Boolean =
      if potentialDivisor > n / 2 then true
      else if n % potentialDivisor == 0 then false
      else aux(potentialDivisor - 1)

    aux(2)
  end isPrime // <- Scala 3: (optional), it is a way to indicate that a code block ends
  // it can be used on if, while, match, for, methods, classes, object

def main(args: Array[String]): Unit = {}

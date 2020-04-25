package lectures.Part1Basics

object Expressions extends App{
  val x = 1 + 2
  println(x)

  val aCondition = true
  val aCondVal = if(aCondition) 5 else 3

  println(aCondVal)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Never do this again, Scala is not imperative, you dont really use loops
  // EVERYTHING IS AN EXPRESSION

  val sCodeBlock = {
    val x = 2
    val y = 6
    if(x > y) "hi" else "bye"
  }
}

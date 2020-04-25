package lectures.Part1Basics

object Recursion extends App {
  def fact(n: Int): Int =
    if(n <= 0) 1
    else n * fact(n - 1)
  println(fact(10))
  // This is a problem because it can cause stack overflow if n is too high

  // Tail Recursion, use recursive call as the last call. Accumulator saves intermediate steps without using the stack
  def bFact(n: Int): BigInt ={
    def helper(x: BigInt, acc: BigInt): BigInt =
      if(x <= 1) acc
      else helper(x - 1, x*acc)
    helper(n,1)
  }
  println(bFact(5000))

  // Practice Problems with Tail Recursion
  // 1) concatenate a string n times
  def tStr(s: String, n: Int): String = {
    def helper(x: Int, acc: String): String =
      if(x<=1) acc
      else helper(x-1, acc+s)
    helper(n, s)
  }
  println(tStr("shit", 10))

  // 2) isPrime
  def isPrime(n: Int): Boolean = {
    def helper(x: Int, isp: Boolean): Boolean =
      if(!isp) false
      else if(x <= 1) true
      else helper(x-1, n % x != 0 && isp)

    helper(n/2, true)
  }
  println(isPrime(13))

  // 3) Fibonacci
  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}

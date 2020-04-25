package lectures.Part1Basics

object Functions extends App {
  def aFunc(a: String, b: Int): String =
    a + " " + b

  println(aFunc("hello", 3))

  def bFunc(s: String, n: Int): String =
    if(n < 1) s
    else s + bFunc(s, n - 1)

  println(bFunc("Shit", 4))
  // USE RECURSION INSTEAD OF LOOPS IN SCALA

  // Practice problems
  // 1) func that says "hi im $name and im $age years old
  def numOne(name: String, age: Int): String =
    "Hi I'm " + name + " and I'm " + age + " years old"
  println(numOne("Ian",28))

  // 2) Factorial function
  def fact(n: Int): Int =
    if(n <= 0) 1
    else n * fact(n - 1)
  println(fact(10))

  // 3) Fibonaci function
  def fib(n: Int): Int =
    if(n <= 2) 1
    else fib(n-1) + fib(n-2)
  println(fib(10))

  // 4) Is a number prime?
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n/2)
  }
  println(isPrime(13))
}

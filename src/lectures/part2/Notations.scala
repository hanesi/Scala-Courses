package lectures.part2OOP

import scala.language.postfixOps

object Notations extends App {
  class Person(val name: String, favMovie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == favMovie
    def +(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def +(s: String): Person = new Person(s"$name, ($s)", this.favMovie, this.age)
    def unary_! : String = s"$name, wtf!" // need space between colon and name for this
    def unary_+ : Person = new Person(name, favMovie, age+1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, i'm $name and i like $favMovie"
    def learns(str: String): String = s"$name learns $str"
    def learnsScala= this learns "Scala"
    def apply(n: Int): String = s"$name watched $favMovie $n times"
  }

  val mary = new Person("Mary", "Inception", 24)
  println(mary.likes("Inception"))
  println(mary likes "Inception") // same as the expression above
  // called infix or operator notation, only works for methods with ONE parameter

  // "Operators" in scala
  val tom = new Person("Tom", "Fight Club", 25)
  println(mary + tom)

  // ALL OPERATORS ARE METHODS
  println(1.+(2)) // + is an operator/method, with the parameter 2 passed to it

  // prefix notation
  val x = -1
  val y = 1.unary_- // these two are equivalent, but only works with -, +, ~, !

  println(!mary)
  println(mary.unary_!) // equivalent

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // equivalent, rarely used because the only difference is a dot
  // can only use with methods that have no params

  // apply
  println(mary.apply())
  println(mary()) // same thing, when an object is called like a function, looks for apply

  /*
  1. Overload plus operator, add another that gets a string, returns new person with nickname
    mary + "the rockstar" => new person "Mary (the rockstar)"
  2. add Age to person class
    add unary + operator
    +mary => incremented age
  3. Add "learns" method in person class
    takes string, returns "Mary learns $string"
    add learns scala method, calls learns method with scala as param
    use it in postfix
  4. Overload Apply to receive numebr and return string
    mary.apply(2) => mary watched move 2 times
   */

  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
}

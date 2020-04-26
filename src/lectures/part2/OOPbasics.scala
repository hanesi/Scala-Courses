package lectures.part2OOP

object OOPbasics extends App {

  val person = new Person("Ian", 28)
  println(person)
  person.greet("Barry")

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.age)
  println(novel.isWrittenBy(author))

  val counter = new Counter(0)
  counter.inc.print
  counter.inc.inc.inc.inc.print
}
// constructor
class Person(name: String, val age: Int) {
  // body
  // x is a field, every time you instantiate a class, all code in block is executed
  val x = 2
  println(1 + 3)

  // function in a class is a method
  def greet(name: String): Unit = println(s"${this.name} says Hi $name")

  // overloading: method with same name and different output. Can do in scala unless same parameters with different output
  def greet(): Unit = println(s"Hi i am $name") // can you this.name, but it is implied because it has no name input

  // multiple constructors
  def this(name: String) = this(name, 0) // needs to be another constructor, nothing else. only used for default parameters
}

/*
novel and writer class
writer = first/last name and yar
  method fullname
novel = name, publication year, author
  authorAge, isWrittenBy (author), copy(new year of release) = new novel instance with new release year
 */

/*
counter class, receives int
  method that receives a count, and increment/decrement by 1. Overload them to receive a param
 */

// class parameters are not fields, dont act like Go structs
// have to add val or var before the param to access it like person.age

class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName: String = firstName +" " + lastName
}

class Novel(name: String, release: Int, author: Writer) {
  def age = release - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int) {
  def inc = new Counter(count+1) // immutability, instances are fixed, can't be modified. Need to return a new instance
  def dec = new Counter(count -1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }
  def print = println(count)
}












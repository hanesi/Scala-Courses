package lectures.part2OOP

object objects extends App {

  // SCALA DOESNT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  // Objcet has static-like functionality

  object Person {
    // "static" or class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method, sole purpose is to build persons from params
    def apply(mother: Person, father: Person): Person = new Person("Robert")
  }
  // objects DO NOT RECEIVE PARAMETERS. otherwise very similar to classes

  class Person(val name: String){
    // instance level functionality
  }
  // classes and objects with same name and scope is called COMPANIONS


  println(Person.N_EYES)
  println(Person.canFly)

  // scala object is a singleton instance; define the object's type and only instance
  // seems similar to Go structs
  val mary = Person // this is instance of person type
  val john = Person
  println(mary == john) // will see that they are equal, they point to the same instance of person

  val mary1 = new Person("Mary") // this is instance of person type
  val john1 = new Person("John")
  println(mary1 == john1) // now says false, because they create new class instances

  val robert = Person(mary1, john1)

  // Scala applications only a scala object with
  // def main(args: Array(String)): Unit
  // Scala shit needs to compile to java code with that entry point

}

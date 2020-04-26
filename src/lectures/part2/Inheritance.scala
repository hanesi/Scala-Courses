package lectures.part2OOP

object Inheritance extends App {
  // Has single class inheritance
  class Animal {
   def eat = println("nomnomnom") // if you do private def, Cat can't access it. If you add protected, you can
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("CrunchCrunch")
    }
  }

  val cat = new Cat
  cat.crunch
  // extending a class means giving it all the non private methods
  // cat is a subclass of animals
  // can only extend one class at a time

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  // class Adult(name:String, age: Int, idCard: String) extends Person // wont work, JVM needs to call Person first, so have to pass in correct arguments (have extra field in adult)
  class Adult(name:String, age: Int, idCard: String) extends Person(name, age) // this works

  // overwriting
  class Dog extends Animal {
    override def eat = println("crunch crunch")
  }
  val dog = new Dog
  dog.eat
  // overwriting works for methods the same as it works for vars and vals
  // fields can be overridden in a constructor
  // all instances will use the overridden stuff when possinble

  // type subsitution, broadly called polymorphism
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat // removed protected from animal.eat for this to work

  // overRIDING  - supply different implementation
  // overLOADING - multiple methods, same names, different inputs and outputs

  // preventing overrides
  // 1 - use final. adding final to methods will prevent overriding
  // 2 - use final on the class. prevents it from being extended
  // 3 - seal the class; can extend classes in this file, but not in others

}

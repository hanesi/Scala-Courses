package lectures.part2OOP

object AbstractDTypes extends App {

  // abstract, dont supply values. you want subclasses to do it
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }
  // abstract classes cant be instantiated
  // val animal = new Animal // wont work

  class Dog extends Animal {
    override val creatureType: String = "canine"
    override def eat: Unit = println("cronch cronch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "meat"
  }
  class Croc extends Animal with Carnivore {
    override val creatureType: String = "crocodile"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = s"im a croc and im eating ${animal.creatureType}"
  }
  // inherits members from both animal and carnivore
  val dog = new Dog
  val croc = new Croc
  croc.eat(dog)

  // traits vs abstract classes; can have abstract and non abstract members
  // Traits dont have constructor params
  // Can only extend one class, but can mix in multiple traits
  // Traits are behavior, but abstract class is a type of thing
}

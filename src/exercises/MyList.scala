package exercises

abstract class MyList {

  /*
  Single linked list that holds integers
  head returns first element
  tail returns remainder of a list
  is empty returns bool
  add takes an int, returns a new list with element added
  toString returns string rep of list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(elem: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]" // need this override, toString is present in the AnyRef class

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(elem: Int): MyList = new Cons(elem, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(elem: Int): MyList = new Cons(elem, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)
}

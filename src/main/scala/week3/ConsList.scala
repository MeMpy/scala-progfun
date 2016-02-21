package week3

trait ConsList[T]{
  def isEmpty:Boolean
  def head:T
  def tail:ConsList[T]
}

class Nil[T] extends ConsList[T]{
  def isEmpty:Boolean = true

  def head:Nothing = throw new NoSuchElementException()
  def tail:Nothing = throw new NoSuchElementException()
}

//this is a code sugar to define automatically two field
//inside the class.
class Cons[T](val head:T, val tail:ConsList[T]) extends ConsList[T]{
  override def isEmpty: Boolean = false
}

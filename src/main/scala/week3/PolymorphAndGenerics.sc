//Generics work like Java.
//Fundamentally generics provide functional polymorphism
//this means that a function can be executed with different type
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

//the long version is the follows
class ConsLongVers[T](_head:T, _tail:ConsList[T]) extends ConsList[T]{
  override def isEmpty: Boolean = false
  def head=_head
  def tail=_tail
}

//Single function can have generics
def singleton[T](elem:T):ConsList[T] = new Cons[T](elem, new Nil[T])

singleton[Int](1)
//we can also write
singleton(1) // because Scala is able to infer the generic type


def nth[T](index:Int, list:ConsList[T]):T={
  def loop(k:Int, list:ConsList[T]):T={
    if(list.isEmpty) throw new IndexOutOfBoundsException()
    if (k==index) list.head
    else loop(k+1,list.tail)
  }
  loop(0,list)
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil())))
nth(0,list)
nth(1,list)
nth(2,list)
nth(3,list)


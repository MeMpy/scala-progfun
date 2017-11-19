
class A(x:Int, y:Int){
  import A._

  def foo = sum(increment(x),y)

  override def toString = x + ", "+y
}

/**
  * A companion class is a singleton ( object class )
  * that helps the real class. It must have the same name
  * of the class but it must be an object ( static )
  * it can be used to instantiate the class without using new
  * and it can be imported inside the class to make all the
  * 'static' methods available to the class
  */
object A{
  def sum(x:Int, y:Int)= x+y

  /**
    * Since the class and its companion are friends
    * the class can see every private members of its companion and
    * vice versa. This is normal because when one defines a private
    * static method in a java class this can be accessible from every
    * where inside the class
    */
  private def increment(x:Int) = x+1

  def apply(x: Int, y: Int): A = new A(x+10, y+10)

  def apply(op: Int => (Int,Int)) : A = new A(op(10)._1 , op(10)._2)
}

val a1 = new A(10,10)
val a2 = A(10,10)
val a3 = A { x => (x+10, x-10) }


a1.foo

/**
  * If you want to name a variable with a
  * reserved keyword in scala you can use the backtick
  * " `` "
  * This is very useful when you have a json
  * which fields are named as reserved keywords
  * then you can name the class fields using the backticks
  * and everything should work fine
  */
case class B(`class`:String)

val b1 = B("B")
b1.`class`




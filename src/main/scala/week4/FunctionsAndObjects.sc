//In scala functions are objects and
// function Types are classes.
//Indeed when we use a function or when
//we define a function, the underling scala
//model is defining a class or an instance
//of a built in class
def f(x:Int):Int = {
  x * x
}
//the real version
object ff extends Function1[Int,Int]{
  override def apply(x:Int):Int={
    x*x
  }
}

//using some syntactic sugar
object fs {
  def apply(x:Int):Int={
    x*x
  }
}
//AnonymVersion
def fa=(x:Int) => x*x

//Anonym real
def far = new Function[Int,Int]{
  def apply(x:Int):Int={
    x*x
  }
}

//particularity
class fc{
  def apply(x:Int):Int={
    x*x
  }
}
//equal to
//class fc extends Function1[Int,Int]{
//  override def apply(x:Int):Int={
//    x*x
//  }
//}

f(2)
ff(2)
fs(2)
fa(2)
far(2)
(new fc)(2)

import week3.{Cons,ConsList,Nil}

object List {

  def apply():ConsList[Nothing]= new Nil

  def apply[T](x:T):ConsList[T] = {
    new Cons[T](x,new Nil)
  }

  def apply[T](x:T,y:T):ConsList[T] = {
    new Cons[T](x, new Cons[T](y, new Nil))
  }
}
List()

List[Int](1)

List(1,2)
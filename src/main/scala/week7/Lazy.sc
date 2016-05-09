//Stream is a list in which the tail
//is not evaluated immediately. It's evaluated
//only when needed namely when it is used
val x = Stream(1,2,3,4)
(1 to 10).toStream
10 #:: x

//this is how cons is implemented in stream
//you can see that the tail is a nemed parameter
//and it is assigned as a function so it will be
//called for real only when the property/function tail
//will be used
//def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
//  ...
//  def tail = tl

//example
def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

streamRange(1,20)
streamRange(1,20).tail
streamRange(1,20).take(4)
//every tail is actually called only when
//we navigate for real inside the collection
streamRange(1,20).take(4).toList

//The problem with this kind of definition of stream is that
//every time we try to access to the tail
//so for this reason we need another trick
//to make sure to evaluate the tail only one

object A {
  lazy val n = {
    print("expansive computation "); List(1)
  }
}
//a lazy val is evaluated only the first time
//the variable is called

A.n
A.n

//This is an example that compare the three type
//of evaluation in scala
def expr = {
  val x = { print("x"); 1 } //strict (normal) eval
  lazy val y = {print("y"); 2 } //lazy eval
  def z = { print("z"); 3 } // by name eval === => by name param
  z + y + x + z + y + x
}
expr


//Infinite sequences
def from(n:Int):Stream[Int] = {
  n #:: from(n+1)
}

val nat = from(0)
nat.take(10).toList

nat map (_ - 1)

val nat2 = nat.filter(_ > 2)

nat2.take(10).toList






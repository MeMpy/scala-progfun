import week3._

/** Covariance talks about the capability
  * to assign a collection of a specific type
  * of object to another collection of a super
  * type of that object
  * For example cont is covariant because I
  * can pass to it every ConsList and the subtyping
  * is preserved
  */

def count[T](list:ConsList[T]):Int={
  if(list.isEmpty) 0
  else 1 + count(list.tail)
}

//Bounds
def count2[T<:Int](list:ConsList[T]):Int=
  count(list)

//Bound to give more precision to the definition
//of the types of the function
def count3[T,G<:Cons[T]](list:G):Int =
  count(list)

val list = new Cons(1, new Cons(2, new Cons(3, new Nil())))
val listStr = new Cons("1", new Cons("2", new Cons("32", new Nil())))
count(list)
count(listStr)

count2(list)
//count2(listStr) //Error

count3(list)
count3(listStr)

//In some cases the covariance is not enabled
val a:Array[Cons[Int]] = Array(
  new Cons(1, new Nil),
  new Cons(1, new Cons(2, new Cons(3, new Nil()))))
val b:Array[ConsList[Int]]
//b = a //Error

//the array[T] is not covariant because
//an array b of type T cannot handle an array
//a that as a type a subtype of T

/**
  * underscore magics
  *
  * The underscore in scala is a wildcard
  * like * in java for importing stuff but
  * of course much more powerful
  *
  */

// imports all the classes in the package matching
import scala.util.matching._

/** in the pattern matching is used
  * to create pattern that match anything
  * but it removes the ability to use the value
  * in the right hand of the case
  * in can be viewed as a default case
  * or as a case in witch the values of the
  * matched argument is not relevant
  */
val a = Some(10)
a match {
  //case Some(x) => 10 + x
  case Some(_) => 1
  case _ => -1
}

//it can also be used with collections
val al = List(1, 2, 3)
al match {
  case List(_,_,x) => x
  case List(_*) => 10
}

/** Anonymos function
  * you can use _ as a wildcard to
  * indicate for any parameter do something
  * regardless of its type ( because in the body of
  * the function we don't need to call specific
  * class method )
  */

al.reduceLeft(_+_)
al.map(_+1)
al.foreach(_ => print(_))
al.foreach(print(_))
//or simply ignoring the parameter
al.foreach( _ => print("hello"))

/** Define our own setter method
  *
  */

class A(a:Int) {
  private var age = a
  //Waring this is not the standard
  //scala name convention, but i used this in
  //order to make the getter and setter more explicit
  def getSetAge = age
  def getSetAge_=(x:Int): Unit = {
    age = if (x<100) x else -1
  }
}

val cl = new A(31)
cl.getSetAge
cl.getSetAge = 10

/** Apply a function partially
  *
  * Sometimes you want to assign a function
  * to a variable without invoking it.
  *
  */

def foo(x:Int, y:Int) = x + y + 10
val funFoo = foo _
funFoo(1,2)

//let's do a less trivial example
def foo1() = foo(10,10)

val aF = foo1
//error because the function has already
//been called ( optional parenthesis )
//aF()

//using underscore you can pass the function
// let's say the pointer to the function
val aF2 = foo1 _
aF2() //it works






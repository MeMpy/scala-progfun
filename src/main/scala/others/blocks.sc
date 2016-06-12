
/**
  * Blocks are a sequence of expressions
  * where only the last expression represent
  * the returning value of the blocks.
  * They are very different from standard oo languages
  * They are used to set the value of a complex elaboration
  * or to creating anonymous functions
  *
  */
val a = {
  val x = 10
  (0 to x).sum
}
val c = { x:Int => x + a + 10 }

def foo(x:Int) = x + a

foo { 10 }
foo ( 10 )
foo { c(10) }

def foo1( x:Int => Int ) = x(a) + 10

foo1 (c)
/**
  * blocks can be assigned to functions as functions parameter
  * as well.
  * They follow the same rules and syntactic sugar of a normal
  * anonymous function definition
  */
foo1 {
  val b = 10
  _ + a + b
}
foo1 ( _ + a + 10 )

//http://stackoverflow.com/questions/22670356/scala-passing-function-as-block-of-code-between-curly-braces
/***
  * foo2 doesn't accept a function but a value
  * by name i.e. something evaluated only when executed
  * this mean that the block passed to foo2 is
  * evaluated only INSIDE the function and not before executing it
  */
def foo2( p: => Int ) = p + 10
/***
  * Here could be the same instead we are declaring
  * a function that accept another function (high level
  * function) with 0 arguments. Also in this case the
  * evaluation of the block is done inside the function
  * practically foo2 and foo3 are the same in theory they
  * use different scala features
  *
  */
def foo3( p: () => Int) = p() + 10

foo2 {
  val b = 10
  b + a
}
foo3 {
  () =>  val b = 10; b + a
}

/***
  * function with more than one parameter
  */

def foo4 (x:String, p: => Int): String = x match {
  case "" => "empty"
  case _ => p.toString
}

foo4("",{5})
//foo4(""){5} error

//Curring
def foo5(f:(String,=>Int) => String)(x:Int):String= x match {
  case x1 if x1 > 10 => f("",x1)
  case x2 => f("not empty", x2)
}

foo5(foo4){
  10
}

foo5(foo4){
  foo {
    c(1)
  }
}

//partially applied function
val f = foo5(foo4)_
f{
  foo {
    c(1)
  }
}

